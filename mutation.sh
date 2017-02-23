#!/usr/bin/env bash

cd `dirname $0`

Class='fr.unice.polytech.devops.g1.'
Processors[0]='OperatorProcessor'
Processors[1]='BinaryRelationInverter'

rm -rf generated
mkdir generated

for p in "${Processors[@]}"
do
    mvn clean
    # cp dossier AmazingExplorer dans generated/nomProcessor (rm src/main/java)
    mkdir generated/$p
    mkdir -p generated/$p/src/main/java
    cp -r AmazingExplorer/src/test generated/$p/src
    cp -r AmazingExplorer/src/main/resources generated/$p/src/main/
    cp resources/pom.xml generated/$p
    # modifier la ligne 121 du pom de AmazingExplorer
    sed -i "121s/.*/<processor>$Class$p<\/processor>/" AmazingExplorer/pom.xml
    ## sed -i "s/<processors>.*<processors\/>/<processors><processor>$p<\/processor><\/processors>/g" AmazingExplorer/pom.xml
    # mvn compile dans AmazingExplorer
    mvn compile
    # mv les sources générées vers generated/nomProcessor/src/main/java
    mv AmazingExplorer/target/generated-sources/spoon/* generated/$p/src/main/java
    cd generated/$p
    # lance les tests sur les sources mutés
    mvn test
    cd ../..
done
