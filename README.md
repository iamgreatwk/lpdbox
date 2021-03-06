# lpdbox [![Build Status](https://travis-ci.org/michaelknigge/lpdbox.svg?branch=master)](https://travis-ci.org/michaelknigge/lpdbox) [![codecov.io](https://codecov.io/github/michaelknigge/lpdbox/coverage.svg?branch=master)](https://codecov.io/github/michaelknigge/lpdbox?branch=master) [![Coverity Status](https://scan.coverity.com/projects/14242/badge.svg)](https://scan.coverity.com/projects/14242) [![Codacy Badge](https://app.codacy.com/project/badge/Grade/9d850e3858674fe79b95aa7e4f73f9ba)](https://www.codacy.com/gh/michaelknigge/lpdbox/dashboard?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=michaelknigge/lpdbox&amp;utm_campaign=Badge_Grade)

This project provides a LPD-Server-Framework written in pure Java. It is not a stand alone LPD-Server. It allows you to add LPD-Server capabilities to your own applications.

# Dependencies
lpdbox uses the [Simple Logging Facade for Java (SLF4J)](https://www.slf4j.org/) for logging. That' all.

# Usage
Because lpdbox is available at [jcenter](https://bintray.com/bintray/jcenter) it is very easy to use lpdbox in your projects. At first, add lpdbox to your build file. If you use Maven, add the following to your build file:

```xml
<dependency>
  <groupId>de.textmode.lpdbox</groupId>
  <artifactId>lpdbox</artifactId>
  <version>1.1</version>
  <type>pom</type>
</dependency>
```

If you use Gradle, add this:

```
dependencies {
    compile 'de.textmode.lpdbox:lpdbox:1.1'
}
```

In your Java code you need to create a `DaemonCommandHandlerFactory` that is able to create `DaemonCommandHandler` objects.

Then use the `LinePrinterDaemonBuilder` to build a `LinePrinterDaemon`. Invoke `run` on the built `LinePrinterDaemon` and
you are done. To stop the `LinePrinterDaemon` just invoke `stop` or `stop(final long timeoutInMillis)`. That's all

The `LinePrinterDaemon` implements the `Runnable` interface so you can easily start the daemon within a thread.

Note that the `LinePrinterDaemon` is multi-threaded. Each client connection is handled by a thread. You can limit the
maximum number of threads using the method `LinePrinterDaemonBuilder.maxThreads(final int maxThreads)`.

# Contribute
If you want to contribute to lpdbox, you're welcome. But please make sure that your changes keep the quality of lpdbox at least at it's current level. So please make sure that your contributions comply with the lpdbox coding conventions (formatting etc.) and that your contributions are validated by JUnit tests.

It is easy to check this - just build the source with `gradle` before creating a pull request. The gradle default tasks will run [checkstyle](http://checkstyle.sourceforge.net/), [findbugs](http://findbugs.sourceforge.net/) and build the JavaDoc. If everything goes well, you're welcome to create a pull request.

Hint: If you use [Eclipse](https://eclipse.org/) as your IDE, you can simply run `gradle eclipse` to create the Eclipse project files. Furthermore you can import Eclipse formatter settings (see file `config/eclipse-formatter.xml`) that will assist you in formatting the lpdbox source code according the used coding conventions (no tabs, UTF-8 encoding, indent by 4 spaces, no line longer than 120 characters, etc.).
