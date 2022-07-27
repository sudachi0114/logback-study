# scala-playground

## jackson-module-scala の勉強

教材: https://kazuhira-r.hatenablog.com/entry/20140419/1397899036

( jackson-module-scala 公式リポジトリ: https://github.com/FasterXML/jackson-module-scala )

### IntelliJ に sbt console が出てこない

- Scala プラグインなどが最新であるか、確認する
- アップデートがきている場合は、してみる
- アップデートして `build.sbt` とかを開いたりして、「sbt プロジェクトとして開きますか？」的なことを聞かれたら出てくると思う

- https://pleiades.io/help/idea/sbt-tool-window.html#sbt_tool_window
- ツールウィンドウじゃないんだよなー、あの下の部分、何ていうんだろう

### scalatest の `should be`

- `Matchers` を mixin する必要がある

結構バージョンで場所が違うみたい

[using matchers - Scalatest](https://www.scalatest.org/user_guide/using_matchers)

```diff
- import org.scalatest.Matchers._
+ import org.scalatest.matchers.should.Matchers
```

公式ドキュメントと、参考記事をいったりきたりすればなんとかなりそう

- FunSpec

これも FunSpec じゃなくて、AnyFunSpec に名前が変わったのかな

[AnyFunSpec - Scalatest](https://www.scalatest.org/getting_started_with_fun_spec)

```diff
- import org.scalatest.FunSpec
+ import org.scalatest.funspec.AnyFunSpec
```


### エラー

- `jackson-module` だと、同じファイル内に case class を書くとエラー
  -　`circe` だとできた気がするので、余計に混乱するなあ.. 
- 一応ここを見たりした: [jacksonを使ってjsonをデシリアライズする](https://qiita.com/spamoc/items/69a4b8fcd0e004b3c4e8)
  - が、エラーメッセージの `non-static inner classes like this can only by instantiated using default, no-argument constructor` の辺で inner classes がダメと言われているので、外に切り出してみたらうまく行った

```console
[info] JacksonModuleSpec:                                                                                                                                                
[info] JacksonModuleSpec                                                                                                                                                 
[info] - should hoge *** FAILED ***                                                                                                                                      
[info]   com.fasterxml.jackson.databind.exc.InvalidDefinitionException: Cannot construct instance of `com.github.sudachi0114.jackson.JacksonModuleSpec$Organization`: non-static inner classes like this can only by instantiated using default, no-argument constructor                                                                          
[info]  at [Source: (String)"{"name":"some organization",                                                                                                                
[info]  "persons":                                                                                                                                                       
[info]   [{"name":"Taro","age":22},                                                                                                                                      
[info]    {"name":"Hanako","age":18},                                                                                                                                    
[info]    {"name":"Saburo","age":25}]}"; line: 1, column: 2]                                                                                                             
[info]   at com.fasterxml.jackson.databind.exc.InvalidDefinitionException.from(InvalidDefinitionException.java:67)                                                       
[info]   at com.fasterxml.jackson.databind.DeserializationContext.reportBadDefinition(DeserializationContext.java:1904)                                                  
[info]   at com.fasterxml.jackson.databind.DatabindContext.reportBadDefinition(DatabindContext.java:400)                                                                 
[info]   at com.fasterxml.jackson.databind.DeserializationContext.handleMissingInstantiator(DeserializationContext.java:1344)                                            
[info]   at com.fasterxml.jackson.databind.deser.BeanDeserializerBase.deserializeFromObjectUsingNonDefault(BeanDeserializerBase.java:1412)                               
[info]   at com.fasterxml.jackson.databind.deser.BeanDeserializer.deserializeFromObject(BeanDeserializer.java:351)                                                       
[info]   at com.fasterxml.jackson.databind.deser.BeanDeserializer.deserialize(BeanDeserializer.java:184)                                                                 
[info]   at com.fasterxml.jackson.databind.deser.DefaultDeserializationContext.readRootValue(DefaultDeserializationContext.java:322)                                     
[info]   at com.fasterxml.jackson.databind.ObjectMapper._readMapAndClose(ObjectMapper.java:4674)                                                                         
[info]   at com.fasterxml.jackson.databind.ObjectMapper.readValue(ObjectMapper.java:3629)                                                                                
[info]   ...                              
[info] Run completed in 221 milliseconds.                                           
[info] Total number of tests run: 1       
[info] Suites: completed 1, aborted 0     
[info] Tests: succeeded 0, failed 1, canceled 0, ignored 0, pending 0               
[info] *** 1 TEST FAILED ***
```

### sbt options

```sbt
scalacOptions ++= Seq("-Xlint", "-deprecation", "-unchecked")
```

- `-Xlint`: Enable recommended warnings
- `-deprecation`: Emit warning and location for usages of deprecated APIs.
- `-unchecked`: Enable additional warnings where generated code depends on assumptions.

[How to use compiler options - Scala docs](https://docs.scala-lang.org/overviews/compiler-options/index.html)

- `incOptions`

```sbt
incOptions := incOptions.value.withNameHashing(true)
```

の設定でエラー出るなと思ったら、`sbt 1.0.0` から廃止されたらしい


> name hashing が常に有効となったため、incOptions.value.withNameHashing(...) はオプションは無くなる。

[sbt 公式ドキュメント](https://www.scala-sbt.org/1.x/docs/ja/Combined+Pages.html#:~:text=name%20hashing%20%E3%81%8C%E5%B8%B8%E3%81%AB%E6%9C%89%E5%8A%B9%E3%81%A8%E3%81%AA%E3%81%A3%E3%81%9F%E3%81%9F%E3%82%81%E3%80%81incOptions.value.withNameHashing(...)%20%E3%81%AF%E3%82%AA%E3%83%97%E3%82%B7%E3%83%A7%E3%83%B3%E3%81%AF%E7%84%A1%E3%81%8F%E3%81%AA%E3%82%8B%E3%80%82)

---

## `feature/scalatest-study`: ScalaTest の勉強

教材: https://docs.scala-lang.org/overviews/scala-book/sbt-scalatest-tdd.html

(Scalatest 公式: https://www.scalatest.org/install)

* 最新版で Scala3 対応してた
  - https://docs.scala-lang.org/scala3/book/tools-sbt.html#using-sbt-with-scalatest

のために ScalaTest を勉強する

## やったこと
- 依存関係の追加 (設定ファイル)
- ライブラリのインストール
- **IntelliJ との連携**
- パッケージ作成
- メインのコード作成・実行
- テストコード作成・実行
- ドキュメント

---

## 実行方法

```console
$ sbt test
```

## 最終着地
* logback の勉強がしたい
  - https://qiita.com/opengl-8080/items/49719f2d35171f017aa9
  - https://labs.septeni.co.jp/entry/2019/03/07/120000
    - ← jackson.module っていう、circe と似たようなライブラリがあるっぽい
  - https://kazuhira-r.hatenablog.com/entry/20140419/1397899036 ← イマココ
  - https://github.com/FasterXML/jackson-module-scala
    - ← scalatest を使っている 
    - ← scalatest 入らない.. ;; (IntelliJ との連携の問題だった)
      - → 入った！&実行できた　← feature/scalatest-study
  
## org.scalatest.funspec.AnyFunSpec

- Scalatest 公式ドキュメント: https://www.scalatest.org/getting_started_with_fun_spec

> By learning to use FunSpec, simple assertions, and the BeforeAndAfter trait, you can become productive in the BDD style of ScalaTest very quickly. You can then learn and use more of ScalaTest over time.

「単純な assertion と、Before, After trait を使って、BDD スタイルで Scalatest を活用する」とある

[BDD: Behavior Driven Development | ふるまい駆動開発](https://ja.wikipedia.org/wiki/%E3%83%93%E3%83%98%E3%82%A4%E3%83%93%E3%82%A2%E9%A7%86%E5%8B%95%E9%96%8B%E7%99%BA)

### 実行方法

```console
$ sbt
sbt:scalatest-sample> testOnly com.github.sudachi0114.simpletest.FunSpecSpec
[info] FunSpecSpec:
[info] A Stack
[info] - should pop values in last-in-first-out order (pending)
[info] - should throw NoSuchElementException if an empty stack is poped (pending)
[info] Run completed in 197 milliseconds.
[info] Total number of tests run: 0
[info] Suites: completed 1, aborted 0
[info] Tests: succeeded 0, failed 0, canceled 0, ignored 0, pending 2
[info] No tests were executed.
[success] Total time: 0 s, completed 2022/07/22 9:22:41
```
