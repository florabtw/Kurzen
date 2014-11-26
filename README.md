Kurzen
======

## Instructions to run locally:

1. Download Play Activator [manually](https://www.playframework.com/download) or via command-line:

    ```
    $ wget http://downloads.typesafe.com/typesafe-activator/1.2.10/typesafe-activator-1.2.10-minimal.zip
    $ unzip typesafe-activator-1.2.10-minimal.zip
    ```
2. Add ```activator``` to Path
3. Clone this repo:

    ```
    $ git clone https://github.com/ncpierson/Kurzen.git
    $ cd Kurzen
    ```
4. Configure database & [application secret](https://www.playframework.com/documentation/2.3.x/ApplicationSecret)
   in ```conf/application.conf```
5. Start application in dev mode (may take awhile first time)
    
    ```
    $ activator run
    ```
6. Visit ```localhost:9000``` and click "Apply this script now!"
7. Enjoy Kurzen
