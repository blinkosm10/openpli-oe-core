DESCRIPTION = "Hardware drivers for Edision ${MACHINE}"
SECTION = "base"
PRIORITY = "required"
LICENSE = "CLOSED"

PV = "${KV}+${SRCDATE}"
PR = "r0"

SRC_URI = "http://downloads.openpli.org/archive/edision/${MACHINE}-drivers-${KV}-${SRCDATE}.zip"

S = "${WORKDIR}"

INHIBIT_PACKAGE_STRIP = "1"

inherit module

FILES:${PN} += "${sysconfdir}/modules-load.d/_${MACHINE}.conf"

do_compile() {
}

do_install() {
	install -d -m 0755 ${D}/${nonarch_base_libdir}/modules/${KV}/extra
	for modname in ${MODNAMES}; do
		install -m 0644 ${S}/${modname}.ko ${D}/${nonarch_base_libdir}/modules/${KV}/extra/${modname}.ko
	done

	install -d -m 0755 ${D}/${sysconfdir}/modules-load.d
	for modname in ${MODNAMES}; do
		echo ${modname} >> ${D}/${sysconfdir}/modules-load.d/_${MACHINE}.conf
	done
}
