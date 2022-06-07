> # Item-Manager-Lib
Gestion d'ItemStacks facilitée avec l'API de Spigot.

---
> ### Dépendances requises
Pour utiliser correctement la lib Item Manager, vous devez intégrer l'API de Spigot dans votre projet.

Vous pouvez le faire à l'aide de Maven dans de votre ``pom.xml``, en y mettant ceci :
```xml
<respositories>
    <repository>
        <id>spigotmc-repo</id>
        <url>https://hub.spigotmc.org/nexus/content/repositories/snapshots/</url>
    </repository>
</respositories>
```

Il vous faudra aussi coller ceci dans la balise ``<dependencies>`` :
```xml
<dependency>
    <groupId>org.spigotmc</groupId>
    <artifactId>spigot-api</artifactId>
    <version>1.18.1-R0.1-SNAPSHOT</version>
    <scope>provided</scope>
</dependency>
```

Si vous utilisez Gradle, dans votre ``build.gradle``, intégrez-y ceci :
```
repositories {
    maven {
        url = 'https://hub.spigotmc.org/nexus/content/repositories/snapshots/'
        
        content {
            includeGroup 'org.bukkit'
            includeGroup 'org.spigotmc'
        }
        
        maven { url = 'https://oss.sonatype.org/content/repositories/snapshots' }
        maven { url = 'https://oss.sonatype.org/content/repositories/central' }
    }
}

dependencies {
  compileOnly 'org.spigotmc:spigot-api:1.18.1-R0.1-SNAPSHOT' // The Spigot API with no shadowing. Requires the OSS repo.
}
```