// Copyright (c) 2018 by Rob Norris
// This software is licensed under the MIT License (MIT).
// For more information see LICENSE or https://opensource.org/licenses/MIT

package skunk
package codec

import cats.implicits._
import skunk.data.Type

trait NumericCodecs {

  val bool: Codec[Boolean] =
   Codec.simple(
      b => if (b) "t" else "f",
      {
        case "t" => Right(true)
        case "f" => Right(false)
        case s   => Left(s"Expected 't' or 'f', got $s")
      },
      Type.bool
    )

  val int2: Codec[Short] = Codec.simple(_.toString, _.toShort.asRight, Type.int2)// todo: validate
  val int4: Codec[Int]   = Codec.simple(_.toString, _.toInt.asRight,   Type.int4)// todo: validate
  val int8: Codec[Long]  = Codec.simple(_.toString, _.toLong.asRight,  Type.int8)// todo: validate

  val float8: Codec[Double]  = Codec.simple(_.toString, _.toDouble.asRight, Type.float8)// todo: validate

}

object numeric extends NumericCodecs