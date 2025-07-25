SUMMARY = "Versioning It with your Version In Git"
HOMEPAGE = "https://github.com/jwodder/versioningit"
AUTHOR = "John Thorvald Wodder II <versioningit@varonathe.org>"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=d295714bdb97baf413d05ad9bf79f827"

DEPENDS += "python3-setuptools"

SRC_URI[sha256sum] = "b91ad7d73e73d21220e69540f20213f2b729a1f9b35c04e9e137eaf28d2214da"

PYPI_PACKAGE = "versioningit"

inherit pypi python_hatchling

BBCLASSEXTEND = "native"
