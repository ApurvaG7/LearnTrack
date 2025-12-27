

* What is JDK, JRE, JVM?

JVM (Java Virtual Machine) is an abstract machine.

It is a specification that provides a runtime environment in which Java bytecode can be executed. 

It can also run those programs that are written in other languages and compiled to Java bytecode.

JRE (Java Runtime Environment), It is also written as Java RTE. 
It's a set of software tools that are used for developing Java applications. 

It is used to provide the runtime environment. 

It contains a set of libraries + other files that the JVM uses at runtime.

JDK (Java Development Kit) is a software development environment that is used to develop Java applications and applets. 

It contains JRE + development tools.







* What is bytecode?

Java bytecode is a set of instructions of Java code that the JVM understands. 

As soon as a Java program is compiled, bytecode for that code is generated.

Java bytecode is the machine code in the form of a .class file. With the help of Java bytecode, we achieve platform independence in Java. 

Machine or platform-independent code is code that runs on multiple computer architectures without requiring any changes.

Low-level and high-level sets of instructions are separated by bytecode. 



* What does “write once, run anywhere” mean?

The key to this portability is the Java Virtual Machine (JVM) and the Java Runtime Environment (JRE).

Compilation to Bytecode: When a Java program is compiled, it's not converted into machine-specific code, but rather into a platform-independent bytecode. 

This bytecode acts as a universal set of instructions.

Execution by JVM: Each target platform (e.g., Windows, macOS, Linux) has its own specific implementation of the JVM. 

When the program is run, the JVM interprets or uses a Just-In-Time (JIT) compiler to translate the generic bytecode into the native machine code that the underlying hardware can understand and execute.

Benefits

The WORA principle offers significant advantages:

Platform Independence: Developers don't need to write separate versions of the same application for different operating systems.

Reduced Development Costs: It saves time and resources by streamlining the development and testing process across multiple environments.

Broader Reach: Applications can run on a vast number of devices, from enterprise servers to embedded systems and Android mobile devices, reaching a wider user base. 