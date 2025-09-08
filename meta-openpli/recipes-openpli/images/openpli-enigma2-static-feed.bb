# Creates the "feed", packages not required for the image
# but that should be built for the feed so that other
# components may use them and install on demand.

# Trick: We want to create the package index, and we don't actually
# package anything, so we "inherit" the package indexer recipe.
require recipes-core/meta/package-index.bb

# We have a GPLv2 license for this recipe...
require conf/license/openpli-gplv2.inc

MACHINE_ESSENTIAL_EXTRA_RDEPENDS ?= ""

OPTIONAL_PACKAGES ?= ""
OPTIONAL_BSP_PACKAGES ?= ""
OPTIONAL_BSP_ENIGMA2_PACKAGES ?= ""

# Get the kernel version for this image, we need it to build conditionally on kernel version
# NB: this only works in the feed, as the kernel needs to be build before the headers are available

inherit linux-kernel-base
KERNEL_VERSION = "${@get_kernelversion_headers('${STAGING_KERNEL_DIR}') or oe.utils.read_file('${STAGING_KERNEL_BUILDDIR}/kernel-abiversion') or oe.utils.read_file('${PKGDATA_DIR}/kernel-depmod/kernel-abiversion')}"

OPTIONAL_PACKAGES += " \
	${@bb.utils.contains('TARGET_ARCH', 'mipsel', '', 'nodejs', d)} \
	"

OPTIONAL_ENIGMA2_PACKAGES = " \
	${@"" and bb.utils.contains('OPENPLI_FEATURES', 'kodi', 'enigma2-plugin-extensions-kodi kodi-addons-meta', '', d)} \
	${@"" and bb.utils.contains('MACHINE_FEATURES', 'kodi', 'enigma2-plugin-extensions-kodi kodi-addons-meta', '', d)} \
	\
	${@bb.utils.contains('OPENPLI_FEATURES', 'qtplugins', 'enigma2-plugin-extensions-qthbbtv enigma2-plugin-extensions-qtstalker', '', d)} \
	${@bb.utils.contains("MACHINE_FEATURES", "webkithbbtv", "enigma2-plugin-extensions-webkithbbtv", "", d)} \
	${@bb.utils.contains("MACHINE_FEATURES", "chromiumos", "enigma2-plugin-extensions-chromium", "", d)} \
	${@bb.utils.contains('OPENPLI_FEATURES', 'openhbbtvbrowser', 'enigma2-plugin-extensions-openhbbtvbrowser', '', d)} \
	"

DEPENDS += "${OPTIONAL_PACKAGES} ${OPTIONAL_ENIGMA2_PACKAGES}"
