MODULE = "OpenWebif"
DESCRIPTION = "Control your receiver with a browser"
LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://README;md5=eb66cb719ed579d6523cf9c3e000d811"

DEPENDS = "python3-cheetah-native"
RDEPENDS:${PN} = "\
	aio-grab \
	python3-cheetah \
	python3-compression \
	python3-ipaddress \
	python3-json \
	python3-misc \
	python3-numbers \
	python3-pprint \
	python3-pyopenssl \
	python3-shell \
	python3-twisted-web \
	python3-unixadmin \
	"

PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit gittag

PV = "git"
PKGV = "${GITPKGVTAG}"

require openplugins-distutils.inc

SRC_URI = "git://github.com/oe-alliance/OpenWebif.git;protocol=https;branch=main \
           file://0001-revert-workaround-for-non-pli-streamproxy.patch \
           file://set-packages-explicit.patch \
           file://fix-module-imports.patch \
           file://get-rid-of-six.patch \
"

# Just a quick hack to "compile" it
do_compile() {
	cheetah-compile -R --nobackup ${S}/plugin
	python3 -m compileall -o2 -b ${PLUGINPATH} ${S}/plugin
}

PLUGINPATH = "${libdir}/enigma2/python/Plugins/Extensions/${MODULE}"
do_install:append() {
	install -d ${D}${PLUGINPATH}
	cp -r ${S}/plugin/* ${D}${PLUGINPATH}
	chmod a+rX ${D}${PLUGINPATH}
}

FILES:${PN} = "${PLUGINPATH}"
FILES:${PN}-src += "${PLUGINPATH}/controllers/views/*.tmpl ${PLUGINPATH}/controllers/views/*/*.tmpl ${PLUGINPATH}/controllers/views/*/*/*.tmpl"

DESCRIPTION:${PN}-vxg = "Adds Google Chrome support to OpenWebif's WebTV"
FILES:${PN}-vxg = "${libdir}/enigma2/python/Plugins/Extensions/OpenWebif/public/vxg"
RDEPENDS:${PN}-vxg =+ "${PN}"
PACKAGES =+ "${PN}-vxg"
