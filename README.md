# scala-playground

## ScalaTest の勉強

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
- ドキュメント ← ｲﾏｺｺ

## 実行方法

```console
$ sbt test
```

## 最終着地
* logback の勉強がしたい
  - https://qiita.com/opengl-8080/items/49719f2d35171f017aa9
  - https://labs.septeni.co.jp/entry/2019/03/07/120000
    - ← jackson.module っていう、circe と似たようなライブラリがあるっぽい
  - https://kazuhira-r.hatenablog.com/entry/20140419/1397899036
  - https://github.com/FasterXML/jackson-module-scala
    - ← scalatest を使っている 
    - ← scalatest 入らない.. ;; (IntelliJ との連携の問題だった)
      - → 入った！&実行できた

## org.scalatest.funspec.AnyFunSpec

- Scalatest 公式ドキュメント: https://www.scalatest.org/getting_started_with_fun_spec

> By learning to use FunSpec, simple assertions, and the BeforeAndAfter trait, you can become productive in the BDD style of ScalaTest very quickly. You can then learn and use more of ScalaTest over time.

「単純な assertion と、Before, After trait を使って、BDD スタイルで Scalatest を活用する」とある

[BDD: Behavior Driven Development](https://ja.wikipedia.org/wiki/%E3%83%93%E3%83%98%E3%82%A4%E3%83%93%E3%82%A2%E9%A7%86%E5%8B%95%E9%96%8B%E7%99%BA)

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