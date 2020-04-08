/**
 */
package com.gtarc.chariot.api.model.spatialdata;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see com.gtarc.chariot.api.model.spatialdata.SpatialdataFactory
 * @model kind="package"
 * @generated
 */
public interface SpatialdataPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "spatialdata";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "www.gt-arc.com/isco/spatialdata";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "com.gtarc.isco.spatialdata";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	SpatialdataPackage eINSTANCE = com.gtarc.chariot.api.model.spatialdata.impl.SpatialdataPackageImpl.init();

	/**
	 * The meta object id for the '{@link com.gtarc.chariot.api.model.spatialdata.impl.SpatialObjectImpl <em>Spatial Object</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.gtarc.chariot.api.model.spatialdata.impl.SpatialObjectImpl
	 * @see com.gtarc.chariot.api.model.spatialdata.impl.SpatialdataPackageImpl#getSpatialObject()
	 * @generated
	 */
	int SPATIAL_OBJECT = 0;

	/**
	 * The number of structural features of the '<em>Spatial Object</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPATIAL_OBJECT_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>Spatial Object</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPATIAL_OBJECT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link com.gtarc.chariot.api.model.spatialdata.impl.PointImpl <em>Point</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.gtarc.chariot.api.model.spatialdata.impl.PointImpl
	 * @see com.gtarc.chariot.api.model.spatialdata.impl.SpatialdataPackageImpl#getPoint()
	 * @generated
	 */
	int POINT = 1;

	/**
	 * The feature id for the '<em><b>Location</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POINT__LOCATION = SPATIAL_OBJECT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Point</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POINT_FEATURE_COUNT = SPATIAL_OBJECT_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Point</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POINT_OPERATION_COUNT = SPATIAL_OBJECT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.gtarc.chariot.api.model.spatialdata.impl.RectangleImpl <em>Rectangle</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.gtarc.chariot.api.model.spatialdata.impl.RectangleImpl
	 * @see com.gtarc.chariot.api.model.spatialdata.impl.SpatialdataPackageImpl#getRectangle()
	 * @generated
	 */
	int RECTANGLE = 2;

	/**
	 * The feature id for the '<em><b>X1</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECTANGLE__X1 = SPATIAL_OBJECT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>X2</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECTANGLE__X2 = SPATIAL_OBJECT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Rectangle</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECTANGLE_FEATURE_COUNT = SPATIAL_OBJECT_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Rectangle</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECTANGLE_OPERATION_COUNT = SPATIAL_OBJECT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.gtarc.chariot.api.model.spatialdata.impl.CircleImpl <em>Circle</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.gtarc.chariot.api.model.spatialdata.impl.CircleImpl
	 * @see com.gtarc.chariot.api.model.spatialdata.impl.SpatialdataPackageImpl#getCircle()
	 * @generated
	 */
	int CIRCLE = 3;

	/**
	 * The feature id for the '<em><b>Location</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CIRCLE__LOCATION = POINT__LOCATION;

	/**
	 * The feature id for the '<em><b>Radius</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CIRCLE__RADIUS = POINT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Circle</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CIRCLE_FEATURE_COUNT = POINT_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Circle</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CIRCLE_OPERATION_COUNT = POINT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.gtarc.chariot.api.model.spatialdata.impl.FreeFormImpl <em>Free Form</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.gtarc.chariot.api.model.spatialdata.impl.FreeFormImpl
	 * @see com.gtarc.chariot.api.model.spatialdata.impl.SpatialdataPackageImpl#getFreeForm()
	 * @generated
	 */
	int FREE_FORM = 4;

	/**
	 * The feature id for the '<em><b>Locations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FREE_FORM__LOCATIONS = SPATIAL_OBJECT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Free Form</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FREE_FORM_FEATURE_COUNT = SPATIAL_OBJECT_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Free Form</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FREE_FORM_OPERATION_COUNT = SPATIAL_OBJECT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.gtarc.chariot.api.model.spatialdata.impl.LocationImpl <em>Location</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.gtarc.chariot.api.model.spatialdata.impl.LocationImpl
	 * @see com.gtarc.chariot.api.model.spatialdata.impl.SpatialdataPackageImpl#getLocation()
	 * @generated
	 */
	int LOCATION = 5;

	/**
	 * The feature id for the '<em><b>Latitude</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCATION__LATITUDE = 0;

	/**
	 * The feature id for the '<em><b>Longitude</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCATION__LONGITUDE = 1;

	/**
	 * The feature id for the '<em><b>Altitude</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCATION__ALTITUDE = 2;

	/**
	 * The number of structural features of the '<em>Location</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCATION_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Location</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCATION_OPERATION_COUNT = 0;


	/**
	 * Returns the meta object for class '{@link com.gtarc.chariot.api.model.spatialdata.SpatialObject <em>Spatial Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Spatial Object</em>'.
	 * @see com.gtarc.chariot.api.model.spatialdata.SpatialObject
	 * @generated
	 */
	EClass getSpatialObject();

	/**
	 * Returns the meta object for class '{@link com.gtarc.chariot.api.model.spatialdata.Point <em>Point</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Point</em>'.
	 * @see com.gtarc.chariot.api.model.spatialdata.Point
	 * @generated
	 */
	EClass getPoint();

	/**
	 * Returns the meta object for the containment reference '{@link com.gtarc.chariot.api.model.spatialdata.Point#getLocation <em>Location</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Location</em>'.
	 * @see com.gtarc.chariot.api.model.spatialdata.Point#getLocation()
	 * @see #getPoint()
	 * @generated
	 */
	EReference getPoint_Location();

	/**
	 * Returns the meta object for class '{@link com.gtarc.chariot.api.model.spatialdata.Rectangle <em>Rectangle</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Rectangle</em>'.
	 * @see com.gtarc.chariot.api.model.spatialdata.Rectangle
	 * @generated
	 */
	EClass getRectangle();

	/**
	 * Returns the meta object for the containment reference '{@link com.gtarc.chariot.api.model.spatialdata.Rectangle#getX1 <em>X1</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>X1</em>'.
	 * @see com.gtarc.chariot.api.model.spatialdata.Rectangle#getX1()
	 * @see #getRectangle()
	 * @generated
	 */
	EReference getRectangle_X1();

	/**
	 * Returns the meta object for the containment reference '{@link com.gtarc.chariot.api.model.spatialdata.Rectangle#getX2 <em>X2</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>X2</em>'.
	 * @see com.gtarc.chariot.api.model.spatialdata.Rectangle#getX2()
	 * @see #getRectangle()
	 * @generated
	 */
	EReference getRectangle_X2();

	/**
	 * Returns the meta object for class '{@link com.gtarc.chariot.api.model.spatialdata.Circle <em>Circle</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Circle</em>'.
	 * @see com.gtarc.chariot.api.model.spatialdata.Circle
	 * @generated
	 */
	EClass getCircle();

	/**
	 * Returns the meta object for the attribute '{@link com.gtarc.chariot.api.model.spatialdata.Circle#getRadius <em>Radius</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Radius</em>'.
	 * @see com.gtarc.chariot.api.model.spatialdata.Circle#getRadius()
	 * @see #getCircle()
	 * @generated
	 */
	EAttribute getCircle_Radius();

	/**
	 * Returns the meta object for class '{@link com.gtarc.chariot.api.model.spatialdata.FreeForm <em>Free Form</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Free Form</em>'.
	 * @see com.gtarc.chariot.api.model.spatialdata.FreeForm
	 * @generated
	 */
	EClass getFreeForm();

	/**
	 * Returns the meta object for the containment reference list '{@link com.gtarc.chariot.api.model.spatialdata.FreeForm#getLocations <em>Locations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Locations</em>'.
	 * @see com.gtarc.chariot.api.model.spatialdata.FreeForm#getLocations()
	 * @see #getFreeForm()
	 * @generated
	 */
	EReference getFreeForm_Locations();

	/**
	 * Returns the meta object for class '{@link com.gtarc.chariot.api.model.spatialdata.Location <em>Location</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Location</em>'.
	 * @see com.gtarc.chariot.api.model.spatialdata.Location
	 * @generated
	 */
	EClass getLocation();

	/**
	 * Returns the meta object for the attribute '{@link com.gtarc.chariot.api.model.spatialdata.Location#getLatitude <em>Latitude</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Latitude</em>'.
	 * @see com.gtarc.chariot.api.model.spatialdata.Location#getLatitude()
	 * @see #getLocation()
	 * @generated
	 */
	EAttribute getLocation_Latitude();

	/**
	 * Returns the meta object for the attribute '{@link com.gtarc.chariot.api.model.spatialdata.Location#getLongitude <em>Longitude</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Longitude</em>'.
	 * @see com.gtarc.chariot.api.model.spatialdata.Location#getLongitude()
	 * @see #getLocation()
	 * @generated
	 */
	EAttribute getLocation_Longitude();

	/**
	 * Returns the meta object for the attribute '{@link com.gtarc.chariot.api.model.spatialdata.Location#getAltitude <em>Altitude</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Altitude</em>'.
	 * @see com.gtarc.chariot.api.model.spatialdata.Location#getAltitude()
	 * @see #getLocation()
	 * @generated
	 */
	EAttribute getLocation_Altitude();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	SpatialdataFactory getSpatialdataFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link com.gtarc.chariot.api.model.spatialdata.impl.SpatialObjectImpl <em>Spatial Object</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.gtarc.chariot.api.model.spatialdata.impl.SpatialObjectImpl
		 * @see com.gtarc.chariot.api.model.spatialdata.impl.SpatialdataPackageImpl#getSpatialObject()
		 * @generated
		 */
		EClass SPATIAL_OBJECT = eINSTANCE.getSpatialObject();

		/**
		 * The meta object literal for the '{@link com.gtarc.chariot.api.model.spatialdata.impl.PointImpl <em>Point</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.gtarc.chariot.api.model.spatialdata.impl.PointImpl
		 * @see com.gtarc.chariot.api.model.spatialdata.impl.SpatialdataPackageImpl#getPoint()
		 * @generated
		 */
		EClass POINT = eINSTANCE.getPoint();

		/**
		 * The meta object literal for the '<em><b>Location</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference POINT__LOCATION = eINSTANCE.getPoint_Location();

		/**
		 * The meta object literal for the '{@link com.gtarc.chariot.api.model.spatialdata.impl.RectangleImpl <em>Rectangle</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.gtarc.chariot.api.model.spatialdata.impl.RectangleImpl
		 * @see com.gtarc.chariot.api.model.spatialdata.impl.SpatialdataPackageImpl#getRectangle()
		 * @generated
		 */
		EClass RECTANGLE = eINSTANCE.getRectangle();

		/**
		 * The meta object literal for the '<em><b>X1</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RECTANGLE__X1 = eINSTANCE.getRectangle_X1();

		/**
		 * The meta object literal for the '<em><b>X2</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RECTANGLE__X2 = eINSTANCE.getRectangle_X2();

		/**
		 * The meta object literal for the '{@link com.gtarc.chariot.api.model.spatialdata.impl.CircleImpl <em>Circle</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.gtarc.chariot.api.model.spatialdata.impl.CircleImpl
		 * @see com.gtarc.chariot.api.model.spatialdata.impl.SpatialdataPackageImpl#getCircle()
		 * @generated
		 */
		EClass CIRCLE = eINSTANCE.getCircle();

		/**
		 * The meta object literal for the '<em><b>Radius</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CIRCLE__RADIUS = eINSTANCE.getCircle_Radius();

		/**
		 * The meta object literal for the '{@link com.gtarc.chariot.api.model.spatialdata.impl.FreeFormImpl <em>Free Form</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.gtarc.chariot.api.model.spatialdata.impl.FreeFormImpl
		 * @see com.gtarc.chariot.api.model.spatialdata.impl.SpatialdataPackageImpl#getFreeForm()
		 * @generated
		 */
		EClass FREE_FORM = eINSTANCE.getFreeForm();

		/**
		 * The meta object literal for the '<em><b>Locations</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FREE_FORM__LOCATIONS = eINSTANCE.getFreeForm_Locations();

		/**
		 * The meta object literal for the '{@link com.gtarc.chariot.api.model.spatialdata.impl.LocationImpl <em>Location</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.gtarc.chariot.api.model.spatialdata.impl.LocationImpl
		 * @see com.gtarc.chariot.api.model.spatialdata.impl.SpatialdataPackageImpl#getLocation()
		 * @generated
		 */
		EClass LOCATION = eINSTANCE.getLocation();

		/**
		 * The meta object literal for the '<em><b>Latitude</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LOCATION__LATITUDE = eINSTANCE.getLocation_Latitude();

		/**
		 * The meta object literal for the '<em><b>Longitude</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LOCATION__LONGITUDE = eINSTANCE.getLocation_Longitude();

		/**
		 * The meta object literal for the '<em><b>Altitude</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LOCATION__ALTITUDE = eINSTANCE.getLocation_Altitude();

	}

} //SpatialdataPackage
