### Herzlich willkommen beim WebProjekt von David, Patrick und Jonas :)

##### Anleitung um das Projekt zu starten:

1. unser Repository **klonen**
2. neues Repository als **ZIP downloaden** auf den eigenen Computer
3. **ZIP entpacken**
4. Ordner der erstellt wurde (sollte *WebProjekt-master* heißen) in *WebProjekt* **umbenennen**
5. Ordner wieder in **ZIP einpacken** (Name des neuen ZIPs ist egal)
6. Mit Netbeans das neu erstellte **ZIP importieren** (File --> Import Project --> From ZIP...)
7. In Netbeans auf im Fenster "Projects" auf Libraries rechts clicken, falls die Treiber für die Datenbank nicht schon vorhanden sind, ansonsten diesen und den nächsten Schritt überspringen.
8. Im darauf folgenden Kontextmenü "Add Library..." anclicken und "Java DB Driver - derby.jar", "Java DB Driver - derbyclient.jar" und "Java DB Driver - derbynet.jar" hinzufügen.
9. importiertes **Projekt starten** (Rechtsklick aufs Projekt --> Run)
9. Beim ersten Start ist die Datenbank noch nicht vorhanden. Aus diesem Grund muss zuerst das "CreateDataBase"-Servlet aufgerufen werden. Dazu im Browser die URL http://localhost:8080/WebProjekt/CreateDataBase aufrufen. Die Seite zeigt nichts an. In Netbeans steht wird allerdings in "Output" bei "GlassFish Server 4.1.1" angezeigt, dass 3 Tabellen erstellt und gefüllt wurden.
9. Nun ist die Applikation bereit und kann über http://localhost:8080/WebProjekt aufgerufen werden.
10. Im Browser das **Netbeans-Plugin schließen** für realitätsnahes Benutzererlebnis
