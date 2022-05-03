SUMMARY = "Dreambox boot splash screen"
SECTION = "base"
PRIORITY = "required"
PACKAGE_ARCH = "${MACHINE_ARCH}"
LICENSE = "CLOSED"

COMPATIBLE_MACHINE = "^(dm800)$"

BINARY_VERSION = "1.3"
PV = "${BINARY_VERSION}"

S = "${WORKDIR}"

SRC_URI = "http://dreamboxupdate.com/download/opendreambox/2.0.0/dreambox-bootlogo/dreambox-bootlogo_${BINARY_VERSION}_${MACHINE}.tar.bz2;name=${MACHINE}"

SRC_URI_append_dm800 = " file://dm800-logo.jpg"

SRC_URI[dm800.md5sum] = "0aacd07cc4d19b388c6441b007e3525a"
SRC_URI[dm800.sha256sum] = "978a7c50fd0c963013477b5ba08462b35597ea130ae428c828bfcbb5c7cf4cac"

do_install() {
    install -d ${D}/boot
    install -m 0755 ${S}/dreambox-bootlogo_${BINARY_VERSION}_${MACHINE}/bootlogo-${MACHINE}.elf.gz ${D}/boot/
    install -m 0755 ${S}/dm800-logo.jpg ${D}/boot/bootlogo-${MACHINE}.jpg
}

inherit deploy

pkg_postinst_${PN}() {
	if [ -z "$D" ]
	then
		umount /boot
	fi
}

pkg_prerm_${PN}() {
	if [ -z "$D" ]
	then
		if mountpoint -q /boot
		then
			mount -o remount,rw,compr=none /boot
		else
			mount -t jffs2 -o rw,compr=none mtd:boot /boot
		fi
	fi
}

pkg_postrm_${PN}() {
	if [ -z "$D" ]
	then
		umount /boot
	fi
}

FILES_${PN} = "/boot"
