DESCRIPTION = "PlutoTV plugin for enigma2"
LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://src/LICENSE;md5=c644709e9dad24bd9bf90ac96687ed2f"

inherit gitpkgv allarch gettext python3-compileall

RDEPENDS:${PN} = "\
    ${PYTHON_PN}-requests \
    "

PV = "1.0+git"
PKGV = "1.0+git${GITPKGV}"

SRCREV = "${AUTOREV}"

SRC_URI = "git://github.com/OpenViX/PlutoTV.git;protocol=https;branch=master"

S="${WORKDIR}/git"
