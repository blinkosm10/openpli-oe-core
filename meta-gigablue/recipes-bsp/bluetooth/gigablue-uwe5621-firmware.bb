SUMMARY = "Firmware files for uwe5621 bluetooth & wifi"
LICENSE = "CLOSED"

inherit allarch

SRC_URI = "file://uwe5621.zip"

S = "${WORKDIR}"

PACKAGES = "${PN}"
FILES:${PN} += "${nonarch_base_libdir}/firmware"

do_install() {
    install -d ${D}${nonarch_base_libdir}/firmware/uwewifi
    install -m 0644 wcnmodem.bin ${D}${nonarch_base_libdir}/firmware
    install -m 0644 wifi_*.ini ${D}${nonarch_base_libdir}/firmware/uwewifi
    install -d ${D}/etc/bluetooth/uwe5621
    install -m 0644 bt_*.ini ${D}/etc/bluetooth/uwe5621
}
