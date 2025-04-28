<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0"
  xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
  xmlns:ex="http://example.org/"
  exclude-result-prefixes="ex"
  xmlns:ns2="http://hw2/">

 <xsl:output method="text" encoding="UTF-8" indent="no"/>

  <xsl:template match="ns2:generateETicketResponse">
@prefix ex: &lt;http://example.org/&gt; .
@prefix xsd: &lt;http://www.w3.org/2001/XMLSchema#&gt; .

    <xsl:apply-templates/>
  </xsl:template>

  <xsl:template match="return">
ex:ticket a ex:ETicket ;
  ex:id &quot;<xsl:value-of select="id"/>&quot;^^xsd:integer ;
  ex:date &quot;<xsl:value-of select="date"/>&quot;^^xsd:date ;
  ex:athleteId &quot;<xsl:value-of select="athleteId"/>&quot;^^xsd:integer .
  </xsl:template>
  
  <xsl:template match="text()"/>

</xsl:stylesheet>
