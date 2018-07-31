/*! ******************************************************************************
 *
 * Pentaho Data Integration
 *
 * Copyright (C) 2002-2017 by Hitachi Vantara : http://www.pentaho.com
 *
 *******************************************************************************
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 ******************************************************************************/
package org.pentaho.di.core.database;

/**
 * @author mbatchelor
 */
public class RedshiftDatabaseMeta extends PostgreSQLDatabaseMeta {

    public RedshiftDatabaseMeta() {
        addExtraOption("REDSHIFT", "tcpKeepAlive", "true");
    }

    @Override
    public int getDefaultDatabasePort() {
        if (getAccessType() == DatabaseMeta.TYPE_ACCESS_NATIVE) {
            return 5439;
        }
        return -1;
    }

    @Override
    public String getDriverClass() {
        if (getAccessType() == DatabaseMeta.TYPE_ACCESS_ODBC) {
            return "sun.jdbc.odbc.JdbcOdbcDriver";
        } else {
            return "com.amazon.redshift.jdbc4.Driver";
        }
    }

    @Override
    public String getURL(String hostname, String port, String databaseName) {
        if (getAccessType() == DatabaseMeta.TYPE_ACCESS_ODBC) {
            return "jdbc:odbc:" + databaseName;
        } else {
            return "jdbc:redshift://" + hostname + ":" + port + "/" + databaseName;
        }
    }

    @Override
    public String getExtraOptionsHelpText() {
        return "http://docs.aws.amazon.com/redshift/latest/mgmt/configure-jdbc-connection.html";
    }

    /**
     * The superclass method checks whether or not the command setFetchSize() is supported by the driver. In the case of
     * Redshift, setFetchSize() is supported, but in the case of LIMIT, the Redshift driver will enforce that the value
     * for fetch size is less than or equal to the value specified in the LIMIT clause.
     * <p>
     * To avoid these problems, this method (and supportsSetMaxRows()) returns false
     *
     * @return false
     */
    @Override
    public boolean isFetchSizeSupported() {
        return false;
    }

    /**
     * Redshift does not recognize the JDBC "setMaxRows" parameter
     *
     * @return false
     */
    @Override
    public boolean supportsSetMaxRows() {
        return false;
    }

    @Override
    public String[] getUsedLibraries() {
        return new String[]{"RedshiftJDBC4_1.0.10.1010.jar"};
    }
}
