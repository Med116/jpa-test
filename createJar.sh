java -cf persistence.jar ~/Desktop/compu-cooking/build/classes/java/main/com/specificapps/compucooking/*.class;
~/Desktop/compu-cooking/build/classes/java/main/com/specificapps/compucooking/entities/*.class


jar cmf ../../../../META-INF/MANIFEST.MF work.jar /home/mark/Desktop/compu-cooking/jars/javax.persistence-2.2.0.jar /home/mark/Desktop/compu-cooking/jars/eclipselink-2.5.0.jar /home/mark/Desktop/compu-cooking/jars/mysql-connector-java-8.0.13.jar com/specificapps/compucooking/*.class com/specificapps/compucooking/entities/*.class ../../../../META-INF/persistence.xml


java -cp  /home/mark/Desktop/compu-cooking/jars/javax.persistence-2.2.0.jar:/home/mark/Desktop/compu-cooking/jars/eclipselink-2.5.0.jar:/home/mark/Desktop/compu-cooking/jars/mysql-connector-java-8.0.13.jar:com/specificapps/compucooking/*.class:com/specificapps/compucooking/entities/*.class com/specificapps/compucooking.CompuCookingApplication


java -cp src/main/java/com/specificapps/compucooking/*.class src/main/java/com/specificapps/compucooking/entities/*.class


See whats in the jar file
jar -tf work.jar

chicken tenders
crab rangoon
steak chees roolls 
egg rolls


javac -cp   com/specificapps/compucooking/*.java com/specificapps/compucooking/entities/*.java -d ./out/ -classpath /home/mark/Desktop/compu-cooking/jars/javax.persistence-2.2.0.jar /home/mark/Desktop/compu-cooking/jars/eclipselink-2.5.0.jar /home/mark/Desktop/compu-cooking/jars/mysql-connector-java-8.0.13.jar




javac -cp   com/specificapps/compucooking/*.java com/specificapps/compucooking/entities/*.java -d /home/mark/Desktop/compu-cooking/out/ -classpath /home/mark/Desktop/compu-cooking/jars/javax.persistence-2.2.0.jar:/home/mark/Desktop/compu-cooking/jars/eclipselink-2.5.0.jar:/home/mark/Desktop/compu-cooking/jars/mysql-connector-java-8.0.13.jar


