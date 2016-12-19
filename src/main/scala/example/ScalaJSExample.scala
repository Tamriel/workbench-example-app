package example

import org.scalajs.dom
import org.scalajs.dom.html

import scala.scalajs.js.annotation.JSExport
import scalatags.JsDom.all._

@JSExport
object ScalaJSExample {
  @JSExport
  def main(target: html.Div) = {
    val (animalA, animalB) = ("fox", "dog")
    target.appendChild(
      div(
        h1("Hello World!"),
        p(
          "The quick brown ", b(animalA),
          " jumps over the lazy ",
          i(animalB), "."
        )
      ).render
    )

    val box = input(
      `type` := "text",
      placeholder := "Type here!"
    ).render

    val output = span.render

    box.onkeyup = (e: dom.Event) => {
      output.textContent =
        box.value.toUpperCase
    }

    target.appendChild(
      div(
        h1("Capital Box!"),
        p(
          "Type here and " +
            "have it capitalized!"
        ),
        div(box),
        div(output)
      ).render
    )
  }
}
