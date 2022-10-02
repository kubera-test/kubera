# kubera

## 現在鋭意作成中です！
日々空き時間を見つけて作成しているところです。  
誤動作するところもあれば、ちょっと変な動きをするところなど多々あると思います。  
生暖かく見守っていただきつつ、気になる所や、こういう機能が合ったら便利だなと思う点などありましたら、Issueにてご報告いただけると幸いです。

## Kubera(仮名) とは
「クベーラ」と読みます。E2Eテストの自動化を簡単に作成、実施できるようにするための自動化サポートツールです。  
決められたルールに従って作成されたテストケース(Excelファイルなど)を読み込んで、そのままテストを実行することができます。

画面の操作は、Selenium,Selenideを利用しています。 JUnit ベースで実行されるので、CIツールと相性が良いです。

操作対象のオブジェクトを特定するためにある程度の`Seleniumでの特定ルール`(CSSセレクタなどの知識)が必要となります。

## 必要な環境
- Java 11 以上
- Maven 3.6.0 以上

## 使い方など
[Wiki](https://github.com/kubera-test/kubera/wiki)にて記載しています。(こちらも作成中です)

## スケルトン
実際にテストプロジェクトを作成する際のスケルトンを[こちらのリポジトリ](https://github.com/kubera-test/kubera-skeleton)にて公開しています。

## 利用しているツール類(Special Thanks)
- Selenium(https://www.selenium.dev/)
- Selenide(https://selenide.org/)
- Apache POI(https://poi.apache.org/)
- テスト自動化の学習用の練習サイト(https://hotel.testplanisphere.dev/ja/, https://github.com/testplanisphere/hotel-example-site)

## ライセンス
KuberaはMITライセンスで公開されています。