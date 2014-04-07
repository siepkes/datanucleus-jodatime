/**********************************************************************
Copyright (c) 2010 Andy Jefferson and others. All rights reserved.
Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.

Contributors:
    ...
**********************************************************************/
package org.datanucleus.store.types.jodatime.rdbms.sql.expression;

import org.datanucleus.store.rdbms.mapping.java.JavaTypeMapping;
import org.datanucleus.store.rdbms.sql.SQLStatement;
import org.datanucleus.store.rdbms.sql.expression.BooleanExpression;
import org.datanucleus.store.rdbms.sql.expression.SQLExpression;
import org.datanucleus.store.rdbms.sql.expression.SQLLiteral;
import org.datanucleus.store.rdbms.sql.expression.StringTemporalExpression;

/**
 * Abstract representation of a JodaTime literal (to be extended by specific cases).
 */
public abstract class JodaLiteral extends StringTemporalExpression implements SQLLiteral
{
    /**
     * Constructor for an DateTime literal with a value.
     * @param stmt the SQL statement
     * @param mapping the mapping
     * @param parameterName Name of the parameter that this represents if any (as JDBC "?")
     */
    public JodaLiteral(SQLStatement stmt, JavaTypeMapping mapping, String parameterName)
    {
        super(stmt, null, mapping);
        this.parameterName = parameterName;
    }

    /* (non-Javadoc)
     * @see org.datanucleus.store.rdbms.sql.expression.DelegatedExpression#eq(org.datanucleus.store.rdbms.sql.expression.SQLExpression)
     */
    @Override
    public BooleanExpression eq(SQLExpression expr)
    {
        if (expr instanceof JodaLiteral)
        {
            return super.eq(((JodaLiteral) expr).delegate);
        }
        return super.eq(expr);
    }

    /* (non-Javadoc)
     * @see org.datanucleus.store.rdbms.sql.expression.DelegatedExpression#ge(org.datanucleus.store.rdbms.sql.expression.SQLExpression)
     */
    @Override
    public BooleanExpression ge(SQLExpression expr)
    {
        if (expr instanceof JodaLiteral)
        {
            return super.ge(((JodaLiteral) expr).delegate);
        }
        return super.ge(expr);
    }

    /* (non-Javadoc)
     * @see org.datanucleus.store.rdbms.sql.expression.DelegatedExpression#gt(org.datanucleus.store.rdbms.sql.expression.SQLExpression)
     */
    @Override
    public BooleanExpression gt(SQLExpression expr)
    {
        if (expr instanceof JodaLiteral)
        {
            return super.gt(((JodaLiteral) expr).delegate);
        }
        return super.gt(expr);
    }

    /* (non-Javadoc)
     * @see org.datanucleus.store.rdbms.sql.expression.DelegatedExpression#le(org.datanucleus.store.rdbms.sql.expression.SQLExpression)
     */
    @Override
    public BooleanExpression le(SQLExpression expr)
    {
        if (expr instanceof JodaLiteral)
        {
            return super.le(((JodaLiteral) expr).delegate);
        }
        return super.le(expr);
    }

    /* (non-Javadoc)
     * @see org.datanucleus.store.rdbms.sql.expression.DelegatedExpression#lt(org.datanucleus.store.rdbms.sql.expression.SQLExpression)
     */
    @Override
    public BooleanExpression lt(SQLExpression expr)
    {
        if (expr instanceof JodaLiteral)
        {
            return super.lt(((JodaLiteral) expr).delegate);
        }
        return super.lt(expr);
    }

    /* (non-Javadoc)
     * @see org.datanucleus.store.rdbms.sql.expression.DelegatedExpression#ne(org.datanucleus.store.rdbms.sql.expression.SQLExpression)
     */
    @Override
    public BooleanExpression ne(SQLExpression expr)
    {
        if (expr instanceof JodaLiteral)
        {
            return super.ne(((JodaLiteral) expr).delegate);
        }
        return super.ne(expr);
    }

    /* (non-Javadoc)
     * @see org.datanucleus.store.rdbms.sql.expression.SQLExpression#isParameter()
     */
    @Override
    public boolean isParameter()
    {
        return delegate.isParameter();
    }

    /* (non-Javadoc)
     * @see org.datanucleus.store.rdbms.sql.expression.SQLLiteral#setNotParameter()
     */
    public void setNotParameter()
    {
        ((SQLLiteral)delegate).setNotParameter();
    }
}