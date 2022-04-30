# all examples related to java crypto


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
