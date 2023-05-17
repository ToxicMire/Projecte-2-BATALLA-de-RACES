import lxml.html
from lxml import etree

document = etree.parse("./template.xsl")
transform = etree.XSLT(document)
source = etree.parse("./battle.xml")
output = transform(source)

output.write("battle.html", pretty_print = True)
print(str(output))