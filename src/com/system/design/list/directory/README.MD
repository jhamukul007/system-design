🧩 Problem Statement:
Design a phone directory with the following operations:

Leetcode: https://leetcode.com/problems/design-phone-directory/description

1. get(): Provide an available number.

2. check(number): Check if a number is available.

3. release(number): Recycle or release a number.

You are given maxNumbers — the total range of numbers that can be assigned (from 0 to maxNumbers - 1).

```agsl
Input:
["PhoneDirectory", "get", "get", "check", "get", "check", "release", "check"]
[[3], [], [], [2], [], [2], [2], [2]]

Output:
[null, 0, 1, true, 2, false, null, true]

```

Constraints:
```agsl
1 <= maxNumbers <= 10⁴

All function calls will be valid (i.e., get() will not be called when no numbers are available)
```





