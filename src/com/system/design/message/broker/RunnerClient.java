package com.system.design.message.broker;

import com.system.design.message.broker.exceptions.InvalidInputException;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import static java.lang.String.format;

public class RunnerClient {
    public static void main(String[] args) throws InterruptedException {
        MessageBroker<Message> messageBroker = new MessageBroker<>();
        List<String> topics = List.of("sms", "email");
        List<String> dlqTopics = List.of("sms.DLQ", "email.DLQ");
        topics.forEach(messageBroker::registerTopic);
        dlqTopics.forEach(dlqTopic -> messageBroker.registerDLQ(topics.get(0), dlqTopic));
        Producer<Message> producer = new ProducerImpl<>(messageBroker);

        Scanner scanner = new Scanner(System.in);

        Consumer<Message> smsConsumer = new ConsumerImpl(messageBroker);
        Thread smsConsumerThread = new Thread(() -> {
            while (true) {
                try {
                    String topic = topics.get(0);
                    Message receivedMessage = smsConsumer.consume(topic);
                    System.out.println(format("Consumed Message from topic: %s and message: %s ", topic, receivedMessage));
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        Thread producerThread = new Thread(() -> {
            while (true) {
                System.out.print("Topic: ");
                String topic = scanner.nextLine();
                System.out.print("Priority: ");
                int priority = Integer.parseInt(scanner.nextLine());

                if (priority < 0 || priority > 10) {
                    throw new InvalidInputException("");
                }
                // Used only for testing priority behavior by publishing multiple messages to a topic
// without starting any consumers.
//                System.out.print("Enable SMS Consumer: ");
//                int shouldEnable = Integer.parseInt(scanner.nextLine());

                System.out.print("Enter the message: ");
                String messageStr = scanner.nextLine();

                Message message = new SimpleMessage();
                message.setMessage(messageStr);
                message.setSentTime(new Date());
                message.setPriority(priority);
                try {
                    producer.produce(topic, message);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
//                if(shouldEnable == 1){
//                    smsConsumerThread.start();
//                }
            }

        });

        Consumer<Message> emailConsumer = new ConsumerImpl(messageBroker);
        Thread emailConsumerThread = new Thread(() -> {
            while (true) {
                try {
                    String topic = topics.get(1);
                    Message receivedMessage = emailConsumer.consume(topic);
                    System.out.println(format("Consumed Message from topic: %s and message: %s ", topic, receivedMessage));
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });


        producerThread.start();
        smsConsumerThread.start();
        emailConsumerThread.start();
    }
}
