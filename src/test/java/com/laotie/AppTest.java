package com.laotie;

import static org.junit.Assert.*;

import org.junit.Test;

import net.sf.jsqlparser.JSQLParserException;
import net.sf.jsqlparser.expression.LongValue;
import net.sf.jsqlparser.expression.operators.relational.EqualsTo;
import net.sf.jsqlparser.parser.CCJSqlParserUtil;
import net.sf.jsqlparser.schema.Column;
import net.sf.jsqlparser.schema.Table;
import net.sf.jsqlparser.statement.select.PlainSelect;
import net.sf.jsqlparser.statement.select.SelectItem;

/**
 * Unit test for simple App.
 */
public class AppTest {
    /**
     * Rigorous Test :-)
     * @throws JSQLParserException 
     */
    @Test
    public void shouldAnswerWithTrue() throws JSQLParserException {
        assertTrue(true);
        String sqlStr = "select 1 from dual where a=b";

        PlainSelect select = (PlainSelect) CCJSqlParserUtil.parse(sqlStr);

        SelectItem selectItem = select.getSelectItems().get(0);
        assertEquals(
                new LongValue(1), selectItem.getExpression());

        Table table = (Table) select.getFromItem();
        assertEquals("dual", table.getName());

        EqualsTo equalsTo = (EqualsTo) select.getWhere();
        Column a = (Column) equalsTo.getLeftExpression();
        Column b = (Column) equalsTo.getRightExpression();
        assertEquals("a", a.getColumnName());
        assertEquals("b", b.getColumnName());
    }
}
