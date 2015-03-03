package com.github.pathikrit

import scala.language.experimental.macros

package object sauron {
  class PathModify[T, U](obj: T, doModify: (T, U => U) => T) {
    def using(mod: U => U): T = doModify(obj, mod)
  }

  def modify[T, U](obj: T)(path: T => U): PathModify[T, U] = macro QuicklensMacros.modify_impl[T, U]
}
