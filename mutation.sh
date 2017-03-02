#!/usr/bin/env bash

cd `dirname $0`

Class='fr.unice.polytech.devops.g1.'
Processors[0]='OperatorProcessor'
Processors[1]='BinaryRelationInverter'
Processors[2]='Add1ToAllNumber'

rm -rf generated
mkdir generated

# Mise en place de "l'environnement" pour les rapports de test
mkdir generated/reports
cp resources/index.html generated/reports
cp -r resources/css generated/reports
cp -r resources/images generated/reports

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
    # lance les tests sur les sources mutés et produit un rapport au format html
    mvn surefire-report:report
    if [ -f target/site/surefire-report.html ];then
        # les rapports sont placés dans le repertoire reports prévu à cet effet
        mv target/site/surefire-report.html ../reports/$p-report.html
        # un index liste tous les rapports disponible
        sed -i "46i\<li><a href=\"./$p-report.html\" title=\"$p\">Processor $p report<\/li>" ../reports/index.html
    else
        sed -i "46i\<li>Processor $p doesn't produce a report. There may be a problem with the compilation.<\/li>" ../reports/index.html
    fi
    cd ../..
done
