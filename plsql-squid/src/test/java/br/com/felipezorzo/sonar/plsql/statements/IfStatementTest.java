/*
 * Sonar PL/SQL Plugin (Community)
 * Copyright (C) 2015 Felipe Zorzo
 * felipe.b.zorzo@gmail.com
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 3 of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02
 */
package br.com.felipezorzo.sonar.plsql.statements;

import static org.sonar.sslr.tests.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;

import br.com.felipezorzo.sonar.plsql.api.PlSqlGrammar;
import br.com.felipezorzo.sonar.plsql.api.RuleTest;

public class IfStatementTest extends RuleTest {

    @Before
    public void init() {
        setRootRule(PlSqlGrammar.IF_STATEMENT);
    }

    @Test
    public void matchesSimpleIf() {
        assertThat(p).matches(""
                + "if true then "
                + "null; "
                + "end if;");
    }
    
    @Test
    public void matchesIfWithElsif() {
        assertThat(p).matches(""
                + "if true then "
                + "null; "
                + "elsif true then "
                + "null; "
                + "end if;");
    }
    
    @Test
    public void matchesIfWithMultipleElsif() {
        assertThat(p).matches(""
                + "if true then "
                + "null; "
                + "elsif true then "
                + "null; "
                + "elsif true then "
                + "null; "
                + "end if;");
    }
    
    @Test
    public void matchesIfWithElse() {
        assertThat(p).matches(""
                + "if true then "
                + "null; "
                + "else "
                + "null; "
                + "end if;");
    }
    
    @Test
    public void matchesIfWithElsifAndElse() {
        assertThat(p).matches(""
                + "if true then "
                + "null; "
                + "elsif true then "
                + "null; "
                + "else "
                + "null; "
                + "end if;");
    }
    
    @Test
    public void matchesNestedIf() {
        assertThat(p).matches(""
                + "if true then "
                + "if true then "
                + "null; "
                + "end if;"
                + "end if;");
    }
    
    @Test
    public void matchesLabeledIf() {
        assertThat(p).matches(""
                + "<<foo>> if true then "
                + "null; "
                + "end if foo;");
    }

}
