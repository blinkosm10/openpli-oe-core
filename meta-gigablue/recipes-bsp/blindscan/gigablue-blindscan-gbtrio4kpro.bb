SUMMARY = "blindscan for Gigablue Model ${MACHINE}"
SECTION = "base"
PRIORITY = "optional"
LICENSE = "CLOSED"
PACKAGE_ARCH = "${MACHINE_ARCH}"

PROVIDES += "virtual/blindscan-dvbs"
RPROVIDES:${PN} += "virtual-blindscan-dvbs"

SRCDATE = "20250507"

PV = "${SRCDATE}"
PR = "r0"

SRC_URI  = "http://downloads.openpli.org/archive/gigablue/${MACHINE}-blindscan-${SRCDATE}.zip"

S = "${WORKDIR}"

do_install() {
    install -d ${D}${bindir}
    install -m 0755 ${S}/gigablue_blindscan ${D}/${bindir}
}

do_package_qa() {
}

FILES:${PN}  = "${bindir}/gigablue_blindscan"

SRC_URI[md5sum] = "b56b2807820b0378da414314403bf52f"
SRC_URI[sha256sum] = "b7d728ce0631679f9fa7c92830843758461f09e1c2cdcb4e4d046020913ae506"

do_prepare_recipe_sysroot[noexec] = "1"
INHIBIT_PACKAGE_STRIP = "1"
INHIBIT_PACKAGE_DEBUG_SPLIT = "1"
do_compile[noexec] = "1"
deltask do_populate_sysroot
