Design a <b> Lightweight Message Broker </b> (Similar to Kafka/RabbitMQ) with Topic-Based Messaging and Priority Support

<h2> Problem Statement </h2>

You are asked to design and implement a Message Broker System that enables asynchronous communication between Producers and Consumers.

<h3> Functional Requirements </h3>

1. Topic-Based Messaging
   * Producers publish messages to specific topics (e.g., "sms", "email").
   *  Consumers subscribe to a specific topic and consume messages from it.


2. Message Prioritization
   * Each message should have a priority (e.g., 0–10), where higher priority messages should be delivered first.


3. Multiple Producers & Consumers
   * The system should allow multiple producers and multiple consumers running concurrently.


4. Thread-Safe Message Exchange
   * Message publishing and consuming must be thread-safe.


5. Interfaces for Extendability
      * Define clean abstractions like Broker, Producer, Consumer, and Message.