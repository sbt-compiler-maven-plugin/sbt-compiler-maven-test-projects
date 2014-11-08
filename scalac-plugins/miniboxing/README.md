<img src="http://scala-miniboxing.org/mbox2-thumbnail.png" alt="Miniboxing Logo" align="right">
#Miniboxing Example Project [![](https://travis-ci.org/miniboxing/miniboxing-example.png?branch=master)](https://travis-ci.org/miniboxing/miniboxing-example)#

This is an example of using the miniboxing plugin with your sbt project. The changes to the normal build script are located in the
[`miniboxingSettings`](https://github.com/miniboxing/miniboxing-example/blob/master/project/Build.scala#L21-34) 
value in [`project/Build.scala`](https://github.com/miniboxing/miniboxing-example/blob/master/project/Build.scala).

For more details on the miniboxing plugin and how to use it, please visit [scala-miniboxing.org](http://scala-miniboxing.org).

Example usage:
```
$ git clone https://github.com/miniboxing/miniboxing-example.git

$ cd miniboxing-example

$ cat src/main/scala/miniboxing/example/Test.scala 
package miniboxing.example

case class MyTuple2[@miniboxed T1, @miniboxed T2](t1: T1, t2: T2)

object Test {
  def main(args: Array[String]): Unit = {
    println("MyTuple of [Double, Double] dot getClass(): " + new MyTuple2(1.1, 1.1).getClass())
    println("MyTuple of [Double, String] dot getClass(): " + new MyTuple2(1.1, "1").getClass())
    println("MyTuple of [String, Double] dot getClass(): " + new MyTuple2("1", 1.1).getClass())
    println("MyTuple of [String, String] dot getClass(): " + new MyTuple2("1", "1").getClass())
  }
}

$ sbt
[info] Loading project definition from /mnt/data1/Work/Workspace/dev/miniboxing-example/project
[info] Set current project to miniboxing-example (in build file:/mnt/data1/Work/Workspace/dev/miniboxing-example/)

> set scalacOptions += "-P:minibox:log"
[info] Defining *:scalacOptions
[info] The new value will be used by compile:scalacOptions
[info] Reapplying settings...
[info] Set current project to miniboxing-example (in build file:/mnt/data1/Work/Workspace/dev/miniboxing-example/)

> compile
[info] Updating {file:/mnt/data1/Work/Workspace/dev/miniboxing-example/}miniboxing-example...
[info] Resolving org.scala-miniboxing.plugins#miniboxing-runtime_2.11;0.3-SNAPSHOT ...
[info] Resolving jline#jline;2.11 ...
[info] Done updating.
[info] Compiling 1 Scala source to /mnt/data1/Work/Workspace/dev/miniboxing-example/target/scala-2.11/classes...

     _____   .__         .__ ____.                     .__ scala-miniboxing.org
    /     \  |__|  ____  |__|\_  |__    _____  ___  ___|__|  ____    _____
   /  \ /  \ |  | /    \ |  | |  __ \  /  ___\ \  \/  /|  | /    \  /  ___\
  /    Y    \|  ||   |  \|  | |  \_\ \(  (_)  ) >    < |  ||   |  \(  /_/  )
  \____|__  /|__||___|  /|__| |____  / \_____/ /__/\_ \|__||___|  / \___  /
          \/          \/           \/                \/         \/ /_____/
 Copyright (c) 2012-2014 Scala Team, École polytechnique fédérale de Lausanne
 Developed and maintained by Vlad Ureche <vlad.ureche@epfl.ch>.

Specializing class MyTuple2...

  // interface:
  abstract trait MyTuple2[T1, T2] extends Product with Serializable {
    def canEqual(x$1: Any): Boolean                                       
    def copy$default$1[T1, T2](): T1 @scala.annotation.unchecked.uncheckedVariance
    def copy$default$2[T1, T2](): T2 @scala.annotation.unchecked.uncheckedVariance
    def copy[T1, T2](t1: T1,t2: T2): miniboxing.example.MyTuple2[T1,T2]   
    def productArity(): Int                                               
    def productElement(x$1: Int): Any                                     
    override def equals(x$1: Any): Boolean                                
    override def hashCode(): Int                                          
    override def productIterator(): Iterator[Any]                         
    override def productPrefix(): String                                  
    override def toString(): String                                       
    val t1(): T1                                                          
    val t1_JJ(val T1_TypeTag: Byte,val T2_TypeTag: Byte): T1 @storage[Long]
    val t1_JL(val T1_TypeTag: Byte): T1 @storage[Long]                    
    val t1_LJ(val T2_TypeTag: Byte): T1                                   
    val t2(): T2                                                          
    val t2_JJ(val T1_TypeTag: Byte,val T2_TypeTag: Byte): T2 @storage[Long]
    val t2_JL(val T1_TypeTag: Byte): T2                                   
    val t2_LJ(val T2_TypeTag: Byte): T2 @storage[Long]                    
  }

  // specialized class:
  case class MyTuple2_JJ[T1sp, T2sp] extends Product with Serializable with MyTuple2[T1sp,T2sp] {
    def <init>(val miniboxing|example|MyTuple2_JJ|T1_TypeTag: Byte,val miniboxing|example|MyTuple2_JJ|T2_TypeTag: Byte,t1: T1sp @storage[Long],t2: T2sp @storage[Long]): miniboxing.example.MyTuple2_JJ[T1sp,T2sp] // is a specialized implementation of constructor MyTuple2
    private[this] val miniboxing|example|MyTuple2_JJ|T1_TypeTag: Byte      // no info
    private[this] val miniboxing|example|MyTuple2_JJ|T2_TypeTag: Byte      // no info
    private[this] val t1: T1sp @storage[Long]                              // is a specialized implementation of value t1
    private[this] val t2: T2sp @storage[Long]                              // is a specialized implementation of value t2
    val t1(): T1sp                                                         // is a forwarder to the specialized member
    val t1_JJ(val T1_TypeTag: Byte,val T2_TypeTag: Byte): T1sp @storage[Long] // is a setter or getter for value t1
    val t1_JL(val T1_TypeTag: Byte): T1sp @storage[Long]                   // is a forwarder to the specialized member
    val t1_LJ(val T2_TypeTag: Byte): T1sp                                  // is a forwarder to the specialized member
    val t2(): T2sp                                                         // is a forwarder to the specialized member
    val t2_JJ(val T1_TypeTag: Byte,val T2_TypeTag: Byte): T2sp @storage[Long] // is a setter or getter for value t2
    val t2_JL(val T1_TypeTag: Byte): T2sp                                  // is a forwarder to the specialized member
    val t2_LJ(val T2_TypeTag: Byte): T2sp @storage[Long]                   // is a forwarder to the specialized member
  }

  // specialized class:
  case class MyTuple2_LJ[T1sp, T2sp] extends Product with Serializable with MyTuple2[T1sp,T2sp] {
    def <init>(val miniboxing|example|MyTuple2_LJ|T2_TypeTag: Byte,t1: T1sp,t2: T2sp @storage[Long]): miniboxing.example.MyTuple2_LJ[T1sp,T2sp] // is a specialized implementation of constructor MyTuple2
    private[this] val miniboxing|example|MyTuple2_LJ|T2_TypeTag: Byte      // no info
    private[this] val t1: T1sp                                             // is a specialized implementation of value t1
    private[this] val t2: T2sp @storage[Long]                              // is a specialized implementation of value t2
    val t1(): T1sp                                                         // is a forwarder to the specialized member
    val t1_JJ(val T1_TypeTag: Byte,val T2_TypeTag: Byte): T1sp @storage[Long] // is a forwarder to the specialized member
    val t1_JL(val T1_TypeTag: Byte): T1sp @storage[Long]                   // is a forwarder to the specialized member
    val t1_LJ(val T2_TypeTag: Byte): T1sp                                  // is a setter or getter for value t1
    val t2(): T2sp                                                         // is a forwarder to the specialized member
    val t2_JJ(val T1_TypeTag: Byte,val T2_TypeTag: Byte): T2sp @storage[Long] // is a forwarder to the specialized member
    val t2_JL(val T1_TypeTag: Byte): T2sp                                  // is a forwarder to the specialized member
    val t2_LJ(val T2_TypeTag: Byte): T2sp @storage[Long]                   // is a setter or getter for value t2
  }

  // specialized class:
  case class MyTuple2_JL[T1sp, T2sp] extends Product with Serializable with MyTuple2[T1sp,T2sp] {
    def <init>(val miniboxing|example|MyTuple2_JL|T1_TypeTag: Byte,t1: T1sp @storage[Long],t2: T2sp): miniboxing.example.MyTuple2_JL[T1sp,T2sp] // is a specialized implementation of constructor MyTuple2
    private[this] val miniboxing|example|MyTuple2_JL|T1_TypeTag: Byte      // no info
    private[this] val t1: T1sp @storage[Long]                              // is a specialized implementation of value t1
    private[this] val t2: T2sp                                             // is a specialized implementation of value t2
    val t1(): T1sp                                                         // is a forwarder to the specialized member
    val t1_JJ(val T1_TypeTag: Byte,val T2_TypeTag: Byte): T1sp @storage[Long] // is a forwarder to the specialized member
    val t1_JL(val T1_TypeTag: Byte): T1sp @storage[Long]                   // is a setter or getter for value t1
    val t1_LJ(val T2_TypeTag: Byte): T1sp                                  // is a forwarder to the specialized member
    val t2(): T2sp                                                         // is a forwarder to the specialized member
    val t2_JJ(val T1_TypeTag: Byte,val T2_TypeTag: Byte): T2sp @storage[Long] // is a forwarder to the specialized member
    val t2_JL(val T1_TypeTag: Byte): T2sp                                  // is a setter or getter for value t2
    val t2_LJ(val T2_TypeTag: Byte): T2sp @storage[Long]                   // is a forwarder to the specialized member
  }

  // specialized class:
  case class MyTuple2_LL[T1sp, T2sp] extends Product with Serializable with MyTuple2[T1sp,T2sp] {
    def <init>(t1: T1sp,t2: T2sp): miniboxing.example.MyTuple2_LL[T1sp,T2sp] // is a specialized implementation of constructor MyTuple2
    private[this] val t1: T1sp                                             // is a specialized implementation of value t1
    private[this] val t2: T2sp                                             // is a specialized implementation of value t2
    val t1(): T1sp                                                         // is a setter or getter for value t1
    val t1_JJ(val T1_TypeTag: Byte,val T2_TypeTag: Byte): T1sp @storage[Long] // is a forwarder to the specialized member
    val t1_JL(val T1_TypeTag: Byte): T1sp @storage[Long]                   // is a forwarder to the specialized member
    val t1_LJ(val T2_TypeTag: Byte): T1sp                                  // is a forwarder to the specialized member
    val t2(): T2sp                                                         // is a setter or getter for value t2
    val t2_JJ(val T1_TypeTag: Byte,val T2_TypeTag: Byte): T2sp @storage[Long] // is a forwarder to the specialized member
    val t2_JL(val T1_TypeTag: Byte): T2sp                                  // is a forwarder to the specialized member
    val t2_LJ(val T2_TypeTag: Byte): T2sp @storage[Long]                   // is a forwarder to the specialized member
  }


[success] Total time: 11 s, completed Jun 4, 2014 2:28:10 AM

> run
[info] Running miniboxing.example.Test 
MyTuple of [Double, Double] dot getClass(): class miniboxing.example.MyTuple2_JJ
MyTuple of [Double, String] dot getClass(): class miniboxing.example.MyTuple2_JL
MyTuple of [String, Double] dot getClass(): class miniboxing.example.MyTuple2_LJ
MyTuple of [String, String] dot getClass(): class miniboxing.example.MyTuple2_LL
[success] Total time: 0 s, completed Jun 4, 2014 2:28:10 AM

> 
```


#### Try miniboxing on your own! [Read more](http://scala-miniboxing.org) or [use miniboxing with your project](https://github.com/miniboxing/miniboxing-example).
Or have a look at an [array reverse example](https://gist.github.com/VladUreche/6891789).
