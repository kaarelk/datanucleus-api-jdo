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
package org.datanucleus.query.typesafe;

/**
 * Representation of an expression in a query.
 * 
 * @param <T> Java type being represented here
 */
public interface Expression<T>
{
    /**
     * Method returning whether this expression equals the other expression.
     * @param expr Other expression
     * @return Whether they are equal
     */
    BooleanExpression eq(Expression expr);

    /**
     * Method returning whether this expression equals the literal.
     * @param t Literal
     * @return Whether they are equal
     */
    BooleanExpression eq(T t);

    /**
     * Method returning whether this expression doesn't equal the other expression.
     * @param expr Other expression
     * @return Whether they are not equal
     */
    BooleanExpression ne(Expression expr);

    /**
     * Method returning whether this expression doesn't equal the literal.
     * @param t literal
     * @return Whether they are not equal
     */
    BooleanExpression ne(T t);

    /**
     * Method to return a numeric expression representing the aggregated count of this expression.
     * @return Numeric expression for the count
     */
    NumericExpression<Long> count();

    /**
     * Method to return a numeric expression representing the aggregated (distinct) count of this expression.
     * @return Numeric expression for the distinct count
     */
    NumericExpression<Long> countDistinct();

    /**
     * Return an expression for whether this expression is an instanceof the supplied class.
     * @param cls Class to check against
     * @return Whether it is an instanceof
     */
    BooleanExpression instanceOf(Class cls);

    /**
     * Return an expression where this expression is cast to the specified type.
     * @param cls Class to cast to
     * @return The cast expression
     */
    Expression cast(Class cls);
}