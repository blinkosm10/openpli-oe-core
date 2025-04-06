DESCRIPTION = "Rytec's XMLTV sources and channels for the EPGImporter"
MAINTAINER = "Rytec forum @ forums.openpli.org"

require conf/license/openpli-gplv2.inc

inherit allarch

PV = "20250325"
SRC_URI = "http://rytecepg.wanwizard.eu/rytec.sources.xml.${PV}.gz"
S = "${WORKDIR}"

RREPLACES_${PN} = "enigma2-plugin-extensions-xmltvimport-rytec"
RCONFLICTS_${PN} = "enigma2-plugin-extensions-xmltvimport-rytec"

PACKAGES = "${PN}"

FILES_${PN} = "${sysconfdir}/epgimport"

do_install() {
	install -d ${D}${sysconfdir}/epgimport
	install -m 644 ${S}/rytec.sources.xml.${PV} ${D}${sysconfdir}/epgimport/rytec.sources.xml
}

SRC_URI[sha256sum] = "984f1f6635865667cea7c92dbf7ffd231025dca240818fbaf81e51bff2ffc552"
