DESCRIPTION = "PLi-FullHD and PLi-FullnightHD skins"
MAINTAINER = "littlesat"
LICENSE = "Proprietary"
LIC_FILES_CHKSUM = "file://usr/share/enigma2/PLi-FullNightHD/skin.xml;beginline=3;endline=8;md5=1794a55df376114c94b4f8446f467920"

inherit gitpkgv allarch

PV = "0.1+git"
PKGV = "0.1+git${GITPKGV}"

SRC_URI = "git://github.com/littlesat/skin-PLiHD.git;protocol=https;branch=master"

FILES:${PN} = "${datadir}/enigma2/"

S = "${WORKDIR}/git"

do_compile[noexec] = "1"

do_install() {
	rm -rf ${S}${datadir}/enigma2/PLi-HD
	rm -rf ${S}${datadir}/enigma2/PLi-HD1
	rm -rf ${S}${datadir}/enigma2/PLi-HD2
	install -d ${D}${datadir}
	cp -r ${S}${datadir}/* ${D}${datadir}/
	chmod -R a+rX ${D}${datadir}/enigma2/
}
