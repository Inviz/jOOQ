/*
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * Other licenses:
 * -----------------------------------------------------------------------------
 * Commercial licenses for this work are available. These replace the above
 * ASL 2.0 and offer limited warranties, support, maintenance, and commercial
 * database integrations.
 *
 * For more information, please visit: http://www.jooq.org/licenses
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 */
package org.jooq.impl;

import org.jetbrains.annotations.*;


import static org.jooq.impl.Names.N_REVERSE;
import static org.jooq.impl.Names.N_STRREVERSE;

import org.jooq.Context;
import org.jooq.Field;

/**
 * @author Lukas Eder
 */
final class Reverse extends AbstractField<String> {

    /**
     * Generated UID
     */
    private static final long   serialVersionUID = -3869043378872335516L;
    private final Field<String> field;

    Reverse(Field<String> field) {
        super(N_REVERSE, field.getDataType());

        this.field = field;
    }

    @Override
    public final void accept(Context<?> ctx) {
        switch (ctx.family()) {















            case CUBRID:
            case HSQLDB:
            case POSTGRES:
            case MARIADB:
            case MYSQL:
            default:
                ctx.visit(N_REVERSE).sql('(').visit(field).sql(')');
                break;
        }
    }
}
