# Sockets
 Relay nodes

![image](https://user-images.githubusercontent.com/80217340/235524994-80dd7621-712e-4672-a2d2-e998a9dbe3a4.png)

## Main
Initializeaza nodurile de destinatie si cel pentru trimitere apoi porneste threadurile pentru fiecare
![image](https://user-images.githubusercontent.com/80217340/235766642-183e24f4-1f04-4086-8838-8d468ca97010.png)

## Destinatie
Asculta pe portul source date de la sender/alt nod destinatie.
Cand primeste un mesaj verifica daca ii este destinat lui, altfel deschide un socket catre urmatorul nod si ii trimite mesajul
![image](https://user-images.githubusercontent.com/80217340/235767192-ae5d7ea3-d092-49a2-843a-eff7ec8817cd.png)
![image](https://user-images.githubusercontent.com/80217340/235767310-93783520-7ddb-486b-a3b2-d8ccc6254275.png)

## Sender
Trimite 100 de pachete sub formaturl "ip_adress number" catre primul nod de destinatie
![image](https://user-images.githubusercontent.com/80217340/235770246-d3788aae-fee9-4431-b3dd-4cc12606ba57.png)
![image](https://user-images.githubusercontent.com/80217340/235770268-d3e3e8f7-b5ba-40fa-8a14-eba8d17e243b.png)

## Output
![image](https://user-images.githubusercontent.com/80217340/235768422-daa4101e-dd78-4c68-bbf1-914904e538af.png)

## Wireshark
![image](https://github.com/CodeKappa/Sockets/blob/main/wireshark.png)
![image](https://github.com/CodeKappa/Sockets/blob/main/tcp.png)

