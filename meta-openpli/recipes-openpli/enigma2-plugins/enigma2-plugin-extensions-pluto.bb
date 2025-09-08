DESCRIPTION = "PlutoTV plugin for enigma2"
LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://src/LICENSE;md5=c644709e9dad24bd9bf90ac96687ed2f"

RDEPENDS:${PN} = "${PYTHON_PN}-requests"

inherit gittag allarch gettext setuptools3-openplugins python3-compileall

PV = "git"
PKGV = "${GITPKGVTAG}"

SRCREV = "${AUTOREV}"

SRC_URI = "git://github.com/OpenViX/PlutoTV.git;protocol=https;branch=master"

S = "${WORKDIR}/git"
