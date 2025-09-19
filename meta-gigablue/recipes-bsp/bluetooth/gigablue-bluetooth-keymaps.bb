SUMMARY = "Gigablue Blootooth RCU keymaps"
MAINTAINER = "gigablue"
LICENSE = "CLOSED"
PACKAGE_ARCH = "${MACHINE_ARCH}"


#different BT RCU device have it's own kl on /etc/keymap/
#according to vendor id and product id of device.

PV = "1.0"
PR = "r1"

SRC_URI  = "file://Vendor_0508_Product_0110.kl"

S = "${WORKDIR}"

do_install() {
    install -d ${D}/etc/keymap
    install -m 0755 ${S}/Vendor_0508_Product_0110.kl ${D}/etc/keymap/
}
