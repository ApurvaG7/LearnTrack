1. Why you used ArrayList instead of array?

 I used ArrayList instead of a normal array because the number of students, courses, trainers, and enrollments is dynamic and unknown at runtime.

Key reasons:

Dynamic size
Arrays have a fixed size, but ArrayList can grow or shrink automatically as data is added or removed.

Ease of use
ArrayList provides built-in methods like add(), remove(), and iteration using loops, which simplifies code.

Better readability and maintainability
Using ArrayList avoids manual resizing and index management.


2. Where you used static members and why?

Static members are used in the IdGenerator class.

Static counters generate unique IDs

No object creation required

Shared across the application

This ensures consistent ID generation for all entities.


3. Where you used inheritance and what you gained from it?

Where inheritance is used:

Student extends Person

Trainer extends Person

* Code reusability
Common fields and methods are written once in Person.

* Cleaner design
Avoids duplication of attributes across Student and Trainer.

* Polymorphism
The method getDisplayName() is overridden differently in Student and Trainer.

* Scalability
New roles (e.g., Admin) can easily extend Person in the future.
