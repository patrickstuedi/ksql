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

package io.confluent.ksql.function.udf.math;

import io.confluent.ksql.function.FunctionCategory;
import io.confluent.ksql.function.udf.Udf;
import io.confluent.ksql.function.udf.UdfDescription;
import io.confluent.ksql.function.udf.UdfParameter;
import io.confluent.ksql.util.KsqlConstants;

@UdfDescription(
        name = "Mod",
        category = FunctionCategory.MATHEMATICAL,
        description = Mod.DESCRIPTION,
        author = KsqlConstants.CONFLUENT_AUTHOR
)

public class Mod {

    static final String DESCRIPTION = "Returns the modulo value of its arguments. Returns null if one of the arguments is null";


    @Udf
    public Integer mod(@UdfParameter final Integer a, @UdfParameter final Integer n) {
        Integer res = isValid(a,n) ? mod(a.doubleValue(), n.doubleValue()) : null;
        return res;
    }

    @Udf
    public Long mod(@UdfParameter final Long a, @UdfParameter final Long n) {
        return isValid(a,n) ? mod(a.doubleValue(), n.doubleValue()) : null;
    }

    @Udf
    public Double mod(@UdfParameter final Double a, @UdfParameter final Double n) {
        if (a == null || n == null){
            return null;
        }

        double res = a.doubleValue() % n.doubleValue();
        return new Double(res);
    }

    private <T> boolean isValid(T a, T n){
        if (a == null || n == null){
            return false;
        }
        return true;
    }

}
