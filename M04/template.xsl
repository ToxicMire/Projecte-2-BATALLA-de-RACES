<?xml version="1.0" encoding = "UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:template match="table">
        <html>
            <head>
                <meta author = "Clàudia Moyano, Pau Rius i Mireia López (1r DAW)"/>
                <meta http-equiv="Cache-Control" content="no-cache, no-store, must-revalidate" />
                <meta http-equiv="Pragma" content="no-cache" />
                <meta http-equiv="Expires" content="0" />
                <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
                <meta name="viewport" content="initial-scale=1, maximum-scale=1" />
                <link rel="shortcut icon" href="images/bow.png"></link>
                <title>Battle of races</title>
            </head>
            <link rel ="stylesheet" href="style.css"/>
            <body>
                
                <div class = "logo">
                    <img src= "images/logo.png"></img>
                </div>
                <div class = "all">
                    <div class = "table">
                        <div class = "tr">
                            <div class = "th col1">
                                <h1>BATTLE ID</h1>
                            </div>
                            
                            <div class = "th col2">
                                <h1>PLAYER ID</h1>
                            </div>

                            <div class = "th col3">
                                <h1>WARRIOR ID</h1>
                            </div>

                            <div class = "th col4">
                                <h1>WARRIOR WEAPON ID</h1>
                            </div>
                            
                            <div class = "th col5">
                                <h1>OPPONENT ID</h1>
                            </div>
                            
                            <div class = "th col6">
                                <h1>OPPONENT WEAPON ID</h1>
                            </div>
                            
                            <div class = "th col7">
                                <h1>INJURIES CAUSED</h1>
                            </div>
                            
                            <div class = "th col8">
                                <h1>INJURIES SUFFERED</h1>
                            </div>
                            
                            <div class = "th col9">
                                <h1>BATTLE POINTS</h1>
                            </div>
                        </div>
                
                    <xsl:for-each select="row">
                        <div class = "tr">
                            <div class = "td col1">
                                <p><xsl:value-of select="field[@name = '1']"/></p>
                            </div>
                            
                            <div class = "td col2">
                                <p><xsl:value-of select="field[@name = '2']"/></p>
                            </div>
                            <div class = "td col3">
                                <p><xsl:value-of select="field[@name = '3']"/></p>
                            </div>
                            <div class = "td col4">
                                <p><xsl:value-of select="field[@name = '4']"/></p>
                            </div>

                            <div class = "td col5">
                                <p><xsl:value-of select="field[@name = '5']"/></p>
                            </div>

                            <div class = "td col6">
                                <p><xsl:value-of select="field[@name = '6']"/></p>
                            </div>

                            <div class = "td col7">
                                <p><xsl:value-of select="field[@name = '7']"/></p>
                            </div>

                            <div class = "td col8">
                                <p><xsl:value-of select="field[@name = '8']"/></p>
                            </div>

                            <div class = "td col9">
                                <p><xsl:value-of select="field[@name = '9']"/></p>
                            </div>
                        </div>
                    </xsl:for-each>
                    </div>
                </div>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>