# Gradleメモ

## Tips

* Gradleを個別にインストールする必要はない。
* アップデートは下記のようにコマンド実行すると、次回コマンド実行時にダウンロードされる。

    ```shell
    ./gradlew wrapper --gradle-version=6.1.1 --distribution-type=bin
    ```
