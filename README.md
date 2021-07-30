# RdP - Redes de Petri / PN - Petri Networks

Authors: Khalil Santana, Arean Luersen
___
## Requirements
This project uses Maven to manage dependencies as well as packaging.
### Runtime requirements:
* An JRE 16 installation
### Building requirements:
* Maven 3
* An JDK 16, preferably OpenJDK
* Internet connection (to download Maven packages)
## Building

```
git clone git@github.com:areamluersen/MF_redes_de_petri.git
cd MF_redes_de_petri
mvn package
```

## Running
This project includes a few PN models in JSON format in the `models` folder so you can get started, 
but you can also provide your own and by passing it's path as an argument.

For example, to run with the default model: `java -jar target/RdP*-with-dependencies.jar `

To run a specific model: `java -jar target/RdP*-with-dependencies.jar models/pn-03.json`

