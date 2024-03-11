// Copyright (c) 2018-2024 by Rob Norris and Contributors
// This software is licensed under the MIT License (MIT).
// For more information see LICENSE or https://opensource.org/licenses/MIT

package skunk.exception

class SCRAMProtocolException(
  detail: String
) extends SkunkException(
  sql = None,
  message = "Unexpected SCRAM protocol failure.",
  detail = Some(detail)
)