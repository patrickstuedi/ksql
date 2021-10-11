/*
 * Copyright 2019 Confluent Inc.
 *
 * Licensed under the Confluent Community License (the "License"; you may not use
 * this file except in compliance with the License. You may obtain a copy of the
 * License at
 *
 * http://www.confluent.io/confluent-community-license
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OF ANY KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations under the License.
 */

package io.confluent.ksql.physical.pull;

import java.util.HashMap;

public class VersionVector {
  private HashMap<String, Long> offsets;

  public static VersionVector EmptyVector(){
    return new VersionVector();
  }

  public VersionVector(){
    this.offsets = new HashMap<>();
  }

  void updateOffset(String topic, long offset){
    long existingOffset = offsets.containsKey(topic) ? offsets.get(topic) : 0;
    long newOffset = Math.max(existingOffset, offset);
    offsets.put(topic, newOffset);
  }
}
