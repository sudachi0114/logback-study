# scala-playground

## jackson-module-scala の勉強

教材: https://kazuhira-r.hatenablog.com/entry/20140419/1397899036

( jackson-module-scala 公式リポジトリ: https://github.com/FasterXML/jackson-module-scala )

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
