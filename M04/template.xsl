<?xml version="1.0" encoding = "UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:template match="/">
        <html>
        
            <head>
            <title>BATTLES</title>
            </head>

            
            <link rel ="stylesheet" href="style.css"/>
            

            <body>
                <table>
                    <tr>
                        <th class="a">BATTLE ID</th>
                        <th class="b">PLAYER ID</th>
                        <th class="c">WARRIOR ID</th>
                        <th class="d">WARRIOR'S WEAPON ID</th>
                        <th class="e">OPPONENT ID</th>
                        <th class="f">OPPONENT'S WEAPON ID</th>
                        <th class="g">INJURIES CAUSED</th>
                        <th class="h">INJURIES SUFFERED</th>
                        <th class="i">BATTLE POINTS</th>
                    </tr>
                    
                    <xsl:for-each select="//row">
                        <tr>
                            <td><xsl:value-of select="field[@name = 'BATTLE_ID']"/></td>
                            <td><xsl:value-of select="field[@name = 'PLAYER_ID']"/></td>
                            <td><xsl:value-of select="field[@name = 'WARRIOR_ID']"/></td>
                            <td><xsl:value-of select="field[@name = 'WARRIOR_WEAPON_ID']"/></td>
                            <td><xsl:value-of select="field[@name = 'OPPONENT_ID']"/></td>
                            <td><xsl:value-of select="field[@name = 'OPPONENT_WEAPON_ID']"/></td>
                            <td><xsl:value-of select="field[@name = 'INJURIES_CAUSED']"/></td>
                            <td><xsl:value-of select="field[@name = 'INJURIES_SUFFERED']"/></td>
                            <td><xsl:value-of select="field[@name = 'BATTLE_POINTS']"/></td>
                        </tr>
                    </xsl:for-each>
                </table>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>