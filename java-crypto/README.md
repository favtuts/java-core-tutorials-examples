# Java Crypto

* [Java SHA-256 and SHA3-256 Hashing Example](https://www.favtuts.com/java-sha-256-and-sha3-256-hashing-example/)
* [Java >> and >>> bitwise shift operators](https://www.favtuts.com/java-and-bitwise-shift-operators/)
* [Java – How to convert byte arrays to Hex](https://www.favtuts.com/java-how-to-convert-byte-arrays-to-hex/)
* [How to reverse a string in Java](https://www.favtuts.com/how-to-reverse-a-string-in-java/)
* [Java – Convert Integer to Binary](https://www.favtuts.com/java-convert-integer-to-binary/)
* [Java – Convert String to Binary](https://www.favtuts.com/java-convert-string-to-binary/)
* [Java MD5 Hashing Example](https://www.favtuts.com/java-md5-hashing-example/)


# create java crypto project

```
mvn archetype:generate -DgroupId=com.favtuts -DartifactId=java-crypto -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false
```

# maven working commands

Change working directory 
```
cd java-crypto
```

Build the project
```
mvn clean package
```

Run the ShaUtils
```
java -cp target/java11-crypto.jar com.favtuts.crypto.hash.ShaUtils args
```
