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
import io.confluent.ksql.function.udf.UdfSchemaProvider;
import io.confluent.ksql.schema.ksql.SqlArgument;
import io.confluent.ksql.schema.ksql.types.SqlBaseType;
import io.confluent.ksql.schema.ksql.types.SqlType;
import io.confluent.ksql.util.KsqlConstants;
import io.confluent.ksql.util.KsqlException;

import java.math.BigDecimal;
import java.util.List;

@UdfDescription(
        name = "Mod",
        category = FunctionCategory.MATHEMATICAL,
        description = Mod.DESCRIPTION,
        author = KsqlConstants.CONFLUENT_AUTHOR
)

public class Mod {

    static final String DESCRIPTION = "Returns the modulo value of its argument according to a modulo n";


    @Udf
    public Integer mod(@UdfParameter final Integer a, @UdfParameter final Integer n) {
        if (a == null || n == null){
            return null;
        }
        return a % n;
    }

    @Udf
    public Long mod(@UdfParameter final Long a, @UdfParameter final Long n) {
        if (a == null || n == null){
            return null;
        }

        return a % n;
    }

    @Udf
    public Double mod(@UdfParameter final Double a, @UdfParameter final Double n) {
        if (a == null || n == null){
            return null;
        }

        return a % n;
    }

    /*
    @Udf(schemaProvider = "absDecimalProvider")
    public BigDecimal mod(@UdfParameter final BigDecimal val) {
        return (val == null) ? null : val.abs();
    }

    @UdfSchemaProvider
    public SqlType absDecimalProvider(final List<SqlArgument> params) {
        final SqlType s = params.get(0).getSqlTypeOrThrow();
        if (s.baseType() != SqlBaseType.DECIMAL) {
            throw new KsqlException("The schema provider method for Abs expects a BigDecimal parameter"
                    + "type");
        }
        return s;
    }
    */
}
