# Gradleメモ

## Tips

* Gradleを個別にインストールする必要はない。
* アップデートは下記のようにコマンド実行すると、次回コマンド実行時にダウンロードされる。

    ```shell
    ./gradlew wrapper --gradle-version=6.1.1 --distribution-type=bin
    ```

## 古くて使えなかった情報

* タスク定義のショートカット
    
    ```groovy
    task hello << {
        println 'Hello world!'
    }
    ```
  * [参考：gradle5.4.1でleftshift()が使えない場合](https://teratail.com/questions/187565)

