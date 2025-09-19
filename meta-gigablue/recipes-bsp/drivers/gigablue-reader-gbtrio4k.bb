SUMMARY = "libreader for GigaBlue Model ${MACHINE}"
SECTION = "base"
PRIORITY = "optional"
LICENSE = "CLOSED"
PACKAGE_ARCH = "${MACHINE_ARCH}"

RDEPENDS:${PN} = "libsdl"

COMPATIBLE_MACHINE = "^(gbtrio4k)$"

SRCDATE = "20250507"

PV = "${SRCDATE}"
PR = "r0"

SRC_URI = "http://downloads.openpli.org/archive/gigablue/${MACHINE}-libreader-${SRCDATE}.tar.gz"

S = "${WORKDIR}"

do_install() {
    install -d ${D}${bindir}
    install -m 0755 ${S}/libreader ${D}/${bindir}
}

do_package_qa() {
}

FILES:${PN}  = "${bindir}/libreader"

SRC_URI[md5sum] = "e49745be2f4e7812a61f4f52c55a1856"
SRC_URI[sha256sum] = "74c0533ae04711700dbbf97e1b7bd13ddcd7a4b05f94c3ea247d8055d312c689"

INSANE_SKIP:${PN} = "already-stripped"
