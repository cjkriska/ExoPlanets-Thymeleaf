package com.charliekriska.exoplanets.services;

import com.charliekriska.exoplanets.models.Planet;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Service
public class SortingService {

    boolean isNameSortAsc;
    boolean isHostnameSortAsc;
    boolean isMassSortAsc;
    boolean isRadiusSortAsc;
    boolean isTempSortAsc;
    boolean isDiscMethodSortAsc;
    boolean isDiscYearSortAsc;
    boolean isDistSortAsc;

    public SortingService() {
        isNameSortAsc = false;
        isHostnameSortAsc = false;
        isMassSortAsc = false;
        isRadiusSortAsc = false;
        isTempSortAsc = false;
        isDiscMethodSortAsc = false;
        isDiscYearSortAsc = false;
        isDistSortAsc = false;
    }

    private Comparator<Planet> compareByName = new Comparator<Planet>() {
        @Override
        public int compare(Planet o1, Planet o2) {
            return o1.getPl_name().compareTo(o2.getPl_name());
        }
    };
    private Comparator<Planet> compareByHostname = new Comparator<Planet>() {
        @Override
        public int compare(Planet o1, Planet o2) {
            return o1.getHostname().compareTo(o2.getHostname());
        }
    };
    // NULLS
    private Comparator<Planet> compareByMass = new Comparator<Planet>() {
        @Override
        public int compare(Planet o1, Planet o2) {
            int i = 1;
            if(isMassSortAsc) {
                i = -i;
            }
            if(o1.getPl_bmasse() == null) {
                return (o2.getPl_bmasse() == null) ? 0 : i;
            }
            if(o2.getPl_bmasse() == null) {
                return -i;
            }
            double o1value = Double.parseDouble(o1.getPl_bmasse());
            double o2value = Double.parseDouble(o2.getPl_bmasse());
            return Double.compare(o1value, o2value);
        }
    };
    // NULLS
    private Comparator<Planet> compareByRadius = new Comparator<Planet>() {
        @Override
        public int compare(Planet o1, Planet o2) {
            int i = 1;
            if(isRadiusSortAsc) {
                i = -i;
            }
            if(o1.getPl_rade() == null) {
                return (o2.getPl_rade() == null) ? 0 : i;
            }
            if(o2.getPl_rade() == null) {
                return -i;
            }
            double o1value = Double.parseDouble(o1.getPl_rade());
            double o2value = Double.parseDouble(o2.getPl_rade());
            return Double.compare(o1value, o2value);
        }
    };
    // NULLS
    private Comparator<Planet> compareByTemp = new Comparator<Planet>() {
        @Override
        public int compare(Planet o1, Planet o2) {
            int i = 1;
            if(isTempSortAsc) {
                i = -i;
            }
            if(o1.getPl_eqt() == null) {
                return (o2.getPl_eqt() == null) ? 0 : i;
            }
            if(o2.getPl_eqt() == null) {
                return -i;
            }
            double o1value = Double.parseDouble(o1.getPl_eqt());
            double o2value = Double.parseDouble(o2.getPl_eqt());
            return Double.compare(o1value, o2value);
        }
    };
    private Comparator<Planet> compareByDiscMethod = new Comparator<Planet>() {
        @Override
        public int compare(Planet o1, Planet o2) {
            return o1.getDiscoverymethod().compareTo(o2.getDiscoverymethod());
        }
    };
    private Comparator<Planet> compareByDiscYear = new Comparator<Planet>() {
        @Override
        public int compare(Planet o1, Planet o2) {
            return o1.getDisc_year().compareTo(o2.getDisc_year());
        }
    };
    // NULLS
    private Comparator<Planet> compareByDist = new Comparator<Planet>() {
        @Override
        public int compare(Planet o1, Planet o2) {
            int i = 1;
            if(isDistSortAsc) {
                i = -i;
            }
            if(o1.getSy_dist() == null) {
                return (o2.getSy_dist() == null) ? 0 : i;
            }
            if(o2.getSy_dist() == null) {
                return -i;
            }
            double o1value = Double.parseDouble(o1.getSy_dist());
            double o2value = Double.parseDouble(o2.getSy_dist());
            return Double.compare(o1value, o2value);
        }
    };

    public void planetSort(String sortBy, List<Planet> planets) {
        switch(sortBy) {
            case "pl_name":
                if(isNameSortAsc) {
                    Collections.sort(planets, Collections.reverseOrder(compareByName));
                    isNameSortAsc = false;
                } else {
                    Collections.sort(planets, compareByName);
                    isNameSortAsc = true;
                }
                break;
            case "hostname":
                if(isHostnameSortAsc) {
                    Collections.sort(planets, Collections.reverseOrder(compareByHostname));
                    isHostnameSortAsc = false;
                } else {
                    Collections.sort(planets, compareByHostname);
                    isHostnameSortAsc = true;
                }
                break;
            case "pl_bmasse":
                if(isMassSortAsc) {
                    Collections.sort(planets, Collections.reverseOrder(compareByMass));
                    isMassSortAsc = false;
                } else {
                    Collections.sort(planets, compareByMass);
                    isMassSortAsc = true;
                }
                break;
            case "pl_rade":
                if(isRadiusSortAsc) {
                    Collections.sort(planets, Collections.reverseOrder(compareByRadius));
                    isRadiusSortAsc = false;
                } else {
                    Collections.sort(planets, compareByRadius);
                    isRadiusSortAsc = true;
                }
                break;
            case "pl_eqt":
                if(isTempSortAsc) {
                    Collections.sort(planets, Collections.reverseOrder(compareByTemp));
                    isTempSortAsc = false;
                } else {
                    Collections.sort(planets, compareByTemp);
                    isTempSortAsc = true;
                }
                break;
            case "discoverymethod":
                if(isDiscMethodSortAsc) {
                    Collections.sort(planets, Collections.reverseOrder(compareByDiscMethod));
                    isDiscMethodSortAsc = false;
                } else {
                    Collections.sort(planets, compareByDiscMethod);
                    isDiscMethodSortAsc = true;
                }
                break;
            case "disc_year":
                if(isDiscYearSortAsc) {
                    Collections.sort(planets, Collections.reverseOrder(compareByDiscYear));
                    isDiscYearSortAsc = false;
                } else {
                    Collections.sort(planets, compareByDiscYear);
                    isDiscYearSortAsc = true;
                }
                break;
            case "sy_dist":
                if(isDistSortAsc) {
                    Collections.sort(planets, Collections.reverseOrder(compareByDist));
                    isDistSortAsc = false;
                } else {
                    Collections.sort(planets, compareByDist);
                    isDistSortAsc = true;
                }
                break;
            default:
                System.out.println("NOT VALID PARAMETER");
                break;

        }
    }

}
